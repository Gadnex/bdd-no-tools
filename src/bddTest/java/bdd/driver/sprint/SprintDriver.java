package bdd.driver.sprint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import bdd.feature.sprint.SprintDsl;
import java.time.LocalDate;
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

  private UUID productId;
  private String sprintName;
  private LocalDate startDate;
  private LocalDate endDate;

  private SprintCreatedEvent sprintCreatedEvent;

  public SprintDriver() {
    sprintRepository = Mockito.mock(SprintRepository.class);
    sprintService = new SprintService(sprintRepository);
  }

  @Override
  public SprintDsl given() {
    return this;
  }

  @Override
  public SprintDsl productWithId(UUID productId) {
    this.productId = productId;
    return this;
  }

  @Override
  public SprintDsl sprintName(String sprintName) {
    this.sprintName = sprintName;
    return this;
  }

  @Override
  public SprintDsl startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  @Override
  public SprintDsl endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  @Override
  public SprintDsl when() {
    return this;
  }

  @Override
  public SprintDsl iCreateTheSprint() {
    CreateSprintCommand createSprintCommand =
        new CreateSprintCommand(productId, sprintName, startDate, endDate);
    sprintCreatedEvent = sprintService.createSprint(createSprintCommand);
    Sprint sprint = new Sprint();
    sprint.applyEvent(sprintCreatedEvent);
    Mockito.when(sprintRepository.findById(sprintCreatedEvent.id())).thenReturn(sprint);
    return this;
  }

  @Override
  public SprintDsl then() {
    return this;
  }

  @Override
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
}
