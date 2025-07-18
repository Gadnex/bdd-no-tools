package bdd.driver.sprint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import bdd.feature.sprint.SprintDsl;
import io.qameta.allure.Step;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import net.binarypaper.bddnotools.sprint.CreateSprintCommand;
import net.binarypaper.bddnotools.sprint.SprintCreatedEvent;
import net.binarypaper.bddnotools.sprint.SprintRepository;
import net.binarypaper.bddnotools.sprint.SprintService;
import net.binarypaper.bddnotools.sprint.domain.Sprint;
import org.mockito.Mockito;

public class SprintDriver implements SprintDsl {

  private final SprintRepository sprintRepository;
  private final SprintService sprintService;
  private final Validator validator;

  private UUID productId;
  private String sprintName;
  private LocalDate startDate;
  private LocalDate endDate;

  private SprintCreatedEvent sprintCreatedEvent;
  private Set<ConstraintViolation<CreateSprintCommand>> constraintViolations;

  public SprintDriver() {
    sprintRepository = Mockito.mock(SprintRepository.class);
    sprintService = new SprintService(sprintRepository);
    validator = Validation.buildDefaultValidatorFactory().getValidator();
  }

  @Override
  @Step("Given")
  public SprintDsl given() {
    return this;
  }

  @Override
  @Step("product with ID {productId}")
  public SprintDsl productWithId(UUID productId) {
    this.productId = productId;
    return this;
  }

  @Override
  @Step("sprint name {sprintName}")
  public SprintDsl sprintName(String sprintName) {
    this.sprintName = sprintName;
    return this;
  }

  @Override
  @Step("start date {startDate}")
  public SprintDsl startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  @Override
  @Step("end date {endDate}")
  public SprintDsl endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  @Override
  @Step("When")
  public SprintDsl when() {
    return this;
  }

  @Override
  @Step("I create the sprint ")
  public SprintDsl iCreateTheSprint() {
    CreateSprintCommand createSprintCommand =
        new CreateSprintCommand(productId, sprintName, startDate, endDate);
    constraintViolations = validator.validate(createSprintCommand);
    if (constraintViolations.isEmpty()) {
      sprintCreatedEvent = sprintService.createSprint(createSprintCommand);
      Sprint sprint = new Sprint();
      sprint.applyEvent(sprintCreatedEvent);
      Mockito.when(sprintRepository.findById(sprintCreatedEvent.id())).thenReturn(sprint);
    }
    return this;
  }

  @Override
  @Step("Then")
  public SprintDsl then() {
    return this;
  }

  @Override
  @Step("the sprint is created")
  public SprintDsl theSprintIsCreated() {
    // Verify sprintCreatedEvent
    assertNotNull(sprintCreatedEvent);
    assertNotNull(sprintCreatedEvent.id());
    assertEquals(productId, sprintCreatedEvent.productId());
    assertEquals(sprintName, sprintCreatedEvent.name());
    assertEquals(startDate, sprintCreatedEvent.startDate());
    assertEquals(endDate, sprintCreatedEvent.endDate());
    // Verify sprintRepository
    Sprint sprint = sprintRepository.findById(sprintCreatedEvent.id());
    assertNotNull(sprint);
    assertEquals(sprintCreatedEvent.id(), sprint.getId());
    assertEquals(productId, sprint.getProductId());
    assertEquals(sprintName, sprint.getName());
    assertEquals(startDate, sprintCreatedEvent.startDate());
    assertEquals(endDate, sprintCreatedEvent.endDate());
    return this;
  }

  @Override
  @Step("invalid product ID")
  public SprintDsl invalidProductId() {
    assertNotNull(constraintViolations);
    assertEquals(1, constraintViolations.size());
    assertEquals("productId", constraintViolations.iterator().next().getPropertyPath().toString());
    return this;
  }

  @Override
  @Step("invalid sprint name")
  public SprintDsl invalidSprintName() {
    assertNotNull(constraintViolations);
    assertEquals(1, constraintViolations.size());
    assertEquals("name", constraintViolations.iterator().next().getPropertyPath().toString());
    return this;
  }
}
