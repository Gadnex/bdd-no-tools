package net.binarypaper.bddnotools.sprint.infrastructure.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.binarypaper.bddnotools.sprint.CreateSprintCommand;
import net.binarypaper.bddnotools.sprint.SprintCreatedEvent;
import net.binarypaper.bddnotools.sprint.SprintService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sprints")
@CrossOrigin(origins = {"${application.cors.origins}"})
@Tag(name = "Sprint API", description = "Manage sprints")
@RequiredArgsConstructor
class SprintController {

  private final SprintService sprintService;

  @PostMapping
  @Operation(
      summary = "Create new sprint",
      description =
          """
            <b>As a</b> scrum master<br>
            <b>I want to</b> create a new sprint<br>
            <b>so that</b> my team can work on the sprint.
          """)
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Sprint created"),
    @ApiResponse(responseCode = "400", description = "Invalid sprint details", content = @Content)
  })
  SprintCreatedEvent createSprint(@RequestBody @Valid CreateSprintCommand command) {
    return sprintService.createSprint(command);
  }
}
