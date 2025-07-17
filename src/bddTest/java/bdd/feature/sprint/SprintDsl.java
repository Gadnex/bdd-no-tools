package bdd.feature.sprint;

import java.time.LocalDate;
import java.util.UUID;

public interface SprintDsl {

  SprintDsl given();

  SprintDsl productWithId(UUID productId);

  SprintDsl sprintName(String sprintName);

  SprintDsl startDate(LocalDate startDate);

  SprintDsl endDate(LocalDate endDate);

  SprintDsl when();

  SprintDsl iCreateTheSprint();

  SprintDsl then();

  SprintDsl theSprintIsCreated(
      UUID productId, String sprintName, LocalDate startDate, LocalDate endDate);
}
