package fi.joufa.safetor.team.service.web.rest;

import fi.joufa.safetor.team.service.mapper.TeamEntityMapper;
import fi.joufa.safetor.team.service.repository.TeamRepository;
import fi.joufa.safetor.teams.domain.Team;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TeamResource {

    private TeamRepository teamRepository;
    private TeamEntityMapper teamEntityMapper;

    public TeamResource(TeamRepository teamRepository, TeamEntityMapper teamEntityMapper) {
        this.teamRepository = teamRepository;
        this.teamEntityMapper = teamEntityMapper;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll().stream()
                .map(teamEntityMapper::teamEntityToTeam)
                .collect(Collectors.toList());
    }
}
