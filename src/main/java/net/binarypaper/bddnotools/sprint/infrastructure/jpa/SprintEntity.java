package net.binarypaper.bddnotools.sprint.infrastructure.jpa;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.binarypaper.bddnotools.sprint.domain.Sprint;

@Entity
@Table(name = "SPRINT")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class SprintEntity {

  @Id private UUID id;

  private UUID productId;

  private String name;

  private LocalDate startDate;

  private LocalDate endDate;

  public SprintEntity(Sprint sprint) {
    id = sprint.getId();
    productId = sprint.getProductId();
    name = sprint.getName();
    startDate = sprint.getStartDate();
    endDate = sprint.getEndDate();
  }

  public Sprint toSprint() {
    Sprint sprint = new Sprint();
    sprint.setId(id);
    sprint.setProductId(productId);
    sprint.setName(name);
    sprint.setStartDate(startDate);
    sprint.setEndDate(endDate);
    return sprint;
  }
}
