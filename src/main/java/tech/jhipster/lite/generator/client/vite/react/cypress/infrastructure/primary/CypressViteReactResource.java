package tech.jhipster.lite.generator.client.vite.react.cypress.infrastructure.primary;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jhipster.lite.generator.client.vite.react.cypress.application.CypressViteReactApplicationService;
import tech.jhipster.lite.generator.project.domain.Project;
import tech.jhipster.lite.generator.project.infrastructure.primary.dto.ProjectDTO;
import tech.jhipster.lite.technical.infrastructure.primary.annotation.GeneratorStep;

@RestController
@RequestMapping("/api/vite/react/cypress")
@Tag(name = "Vite - React")
class CypressViteReactResource {

  private final CypressViteReactApplicationService cypressViteReactApplicationService;

  public CypressViteReactResource(CypressViteReactApplicationService cypressViteReactApplicationService) {
    this.cypressViteReactApplicationService = cypressViteReactApplicationService;
  }

  @Operation(summary = "Add Cypress to Vite+React", description = "Add Cypress to Vite+React project")
  @ApiResponse(responseCode = "500", description = "An error occurred while adding cypress to Vite+React project")
  @PostMapping
  @GeneratorStep(id = "vite-react-cypress")
  public void init(@RequestBody ProjectDTO projectDTO) {
    Project project = ProjectDTO.toProject(projectDTO);
    cypressViteReactApplicationService.init(project);
  }
}
