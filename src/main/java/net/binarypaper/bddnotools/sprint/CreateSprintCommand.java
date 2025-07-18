package net.binarypaper.bddnotools.sprint;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

public record CreateSprintCommand(
    @NotNull UUID productId,
    @NotNull @Size(min = 3, max = 100) String name,
    LocalDate startDate,
    LocalDate endDate) {}
