package net.binarypaper.bddnotools.sprint;

import lombok.extern.slf4j.Slf4j;
import net.binarypaper.bddnotools.sprint.domain.Sprint;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SprintService {

  private final SprintRepository sprintRepository;

  public SprintService(SprintRepository sprintRepository) {
    this.sprintRepository = sprintRepository;
  }

  public SprintCreatedEvent createSprint(CreateSprintCommand command) {
    Sprint sprint = new Sprint();
    SprintCreatedEvent sprintCreatedEvent = sprint.createSprint(command);
    sprintRepository.save(sprint);
    log.atInfo().addKeyValue("sprintCreatedEvent", sprintCreatedEvent).log("Sprint created");
    return sprintCreatedEvent;
  }
}
