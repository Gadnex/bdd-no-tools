package net.binarypaper.bddnotools.sprint;

import java.util.UUID;
import net.binarypaper.bddnotools.sprint.domain.Sprint;

public interface SprintRepository {

  void save(Sprint sprint);

  Sprint findById(UUID id);
}
