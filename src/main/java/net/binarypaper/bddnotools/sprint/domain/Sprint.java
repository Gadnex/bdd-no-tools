package net.binarypaper.bddnotools.sprint.domain;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.binarypaper.bddnotools.sprint.CreateSprintCommand;
import net.binarypaper.bddnotools.sprint.SprintCreatedEvent;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sprint {

  private UUID id;

  private UUID productId;

  private String name;

  private LocalDate startDate;

  private LocalDate endDate;

  public SprintCreatedEvent createSprint(CreateSprintCommand command) {
    id = UUID.randomUUID();
    productId = command.productId();
    name = command.name();
    startDate = command.startDate();
    endDate = command.endDate();
    return new SprintCreatedEvent(id, productId, name, startDate, endDate);
  }

  public void applyEvent(SprintCreatedEvent sprintCreatedEvent) {
    id = sprintCreatedEvent.id();
    productId = sprintCreatedEvent.productId();
    name = sprintCreatedEvent.name();
    startDate = sprintCreatedEvent.startDate();
    endDate = sprintCreatedEvent.endDate();
  }
}
