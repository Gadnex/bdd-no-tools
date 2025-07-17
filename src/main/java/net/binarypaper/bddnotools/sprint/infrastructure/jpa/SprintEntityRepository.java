package net.binarypaper.bddnotools.sprint.infrastructure.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintEntityRepository extends JpaRepository<SprintEntity, UUID> {}
