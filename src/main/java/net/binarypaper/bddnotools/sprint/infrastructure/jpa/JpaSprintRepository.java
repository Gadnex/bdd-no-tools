package net.binarypaper.bddnotools.sprint.infrastructure.jpa;

import jakarta.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import net.binarypaper.bddnotools.sprint.SprintRepository;
import net.binarypaper.bddnotools.sprint.domain.Sprint;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JpaSprintRepository implements SprintRepository {

  private final SprintEntityRepository jpaSprintRepository;

  @Override
  @Transactional
  public void save(Sprint sprint) {
    SprintEntity sprintEntity = new SprintEntity(sprint);
    jpaSprintRepository.save(sprintEntity);
  }

  @Override
  public Sprint findById(UUID id) {
    Optional<SprintEntity> sprintEntity = jpaSprintRepository.findById(id);
    return sprintEntity.map(SprintEntity::toSprint).orElse(null);
  }
}
