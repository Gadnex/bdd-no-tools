package bdd.driver.sprint;

import bdd.feature.sprint.SprintDsl;
import java.time.LocalDate;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;

public class SprintDriver implements SprintDsl {

  @Override
  public SprintDsl given() {
    Assertions.fail("Test driver not yet implemented");
    return this;
  }

  @Override
  public SprintDsl productWithId(UUID productId) {
    Assertions.fail("Test driver not yet implemented");
    return this;
  }

  @Override
  public SprintDsl sprintName(String sprintName) {
    Assertions.fail("Test driver not yet implemented");
    return this;
  }

  @Override
  public SprintDsl startDate(LocalDate startDate) {
    Assertions.fail("Test driver not yet implemented");
    return this;
  }

  @Override
  public SprintDsl endDate(LocalDate endDate) {
    Assertions.fail("Test driver not yet implemented");
    return this;
  }

  @Override
  public SprintDsl when() {
    Assertions.fail("Test driver not yet implemented");
    return this;
  }

  @Override
  public SprintDsl iCreateTheSprint() {
    Assertions.fail("Test driver not yet implemented");
    return this;
  }

  @Override
  public SprintDsl then() {
    Assertions.fail("Test driver not yet implemented");
    return this;
  }

  @Override
  public SprintDsl theSprintIsCreated(String sprintName, LocalDate startDate, LocalDate endDate) {
    Assertions.fail("Test driver not yet implemented");
    return this;
  }
}
