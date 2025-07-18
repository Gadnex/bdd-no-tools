package bdd.feature.sprint;

import bdd.driver.sprint.SprintDriver;
import io.qameta.allure.Story;
import java.time.LocalDate;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Story(
    """
    As a scrum master
    I want to create a sprint
    so that my team can plan the work for the next sprint.
    """)
@DisplayName("Create a sprint")
class CreateSprintTest {

  private SprintDsl scrumMaster;

  @BeforeEach
  void setUp() {
    scrumMaster = new SprintDriver();
  }

  @Test
  @DisplayName("with dates")
  void createSprintWithDates() {
    scrumMaster
        .given()
        .productWithId(UUID.fromString("7e1f20a5-3aaf-45e0-a04c-a94ab3a85442"))
        .sprintName("Sprint 1")
        .startDate(LocalDate.of(2025, 8, 4))
        .endDate(LocalDate.of(2025, 8, 15))
        .when()
        .iCreateTheSprint()
        .then()
        .theSprintIsCreated();
  }

  @Test
  @DisplayName("with no dates")
  void createSprintWithNoDates() {
    scrumMaster
        .given()
        .productWithId(UUID.fromString("374f7929-bd6b-4178-88f2-c273aa48134c"))
        .sprintName("Sprint no dates")
        .when()
        .iCreateTheSprint()
        .then()
        .theSprintIsCreated();
  }

  @Test
  @DisplayName("with no product ID")
  void createSprintWithNoProductId() {
    scrumMaster
        .given()
        .sprintName("Sprint no product ID")
        .when()
        .iCreateTheSprint()
        .then()
        .invalidProductId();
  }

  @Test
  @DisplayName("with no name")
  void createSprintWithNoName() {
    scrumMaster
        .given()
        .productWithId(UUID.fromString("374f7929-bd6b-4178-88f2-c273aa48134c"))
        .when()
        .iCreateTheSprint()
        .then()
        .invalidSprintName();
  }

  @Test
  @DisplayName("with name less than 3 characters long")
  void createSprintWithNameLessThan3CharsLong() {
    scrumMaster
        .given()
        .productWithId(UUID.fromString("374f7929-bd6b-4178-88f2-c273aa48134c"))
        .sprintName("12")
        .when()
        .iCreateTheSprint()
        .then()
        .invalidSprintName();
  }

  @Test
  @DisplayName("with name more than 100 characters long")
  void createSprintWithNameMoreThan100CharsLong() {
    scrumMaster
        .given()
        .productWithId(UUID.fromString("374f7929-bd6b-4178-88f2-c273aa48134c"))
        .sprintName(
            "abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz123")
        .when()
        .iCreateTheSprint()
        .then()
        .invalidSprintName();
  }
}
