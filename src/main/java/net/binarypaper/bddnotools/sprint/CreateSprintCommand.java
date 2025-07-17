package net.binarypaper.bddnotools.sprint;

import java.time.LocalDate;
import java.util.UUID;

public record CreateSprintCommand(
    UUID productId, String name, LocalDate startDate, LocalDate endDate) {}
