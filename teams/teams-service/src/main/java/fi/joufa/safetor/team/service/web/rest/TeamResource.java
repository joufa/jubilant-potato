package fi.joufa.safetor.team.service.web.rest;

import fi.joufa.safetor.team.service.mapper.TeamEntityMapper;
import fi.joufa.safetor.team.service.repository.TeamRepository;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TeamResource {

  private final Logger log = LoggerFactory.getLogger(TeamResource.class);

  private TeamRepository teamRepository;
  private TeamEntityMapper teamEntityMapper;

  public TeamResource(TeamRepository teamRepository, TeamEntityMapper teamEntityMapper) {
    this.teamRepository = teamRepository;
    this.teamEntityMapper = teamEntityMapper;
  }

  @GetMapping("/teams")
  public List<TeamVM> getAllTeams() {
    return teamRepository.findAll().stream()
        .map(teamEntityMapper::entityToVm)
        .collect(Collectors.toList());
  }

  @PostMapping("/teams")
  public ResponseEntity<TeamVM> createTeam(@Valid @RequestBody TeamVM teamVM)
      throws URISyntaxException {
    log.debug("REST request to create a team : {}", teamVM);
    final TeamVM createdTeam =
        teamEntityMapper.entityToVm(teamRepository.save(teamEntityMapper.vmToEntity(teamVM)));
    return ResponseEntity.created(new URI("/api/teams/" + createdTeam.getId())).body(createdTeam);
  }
}
