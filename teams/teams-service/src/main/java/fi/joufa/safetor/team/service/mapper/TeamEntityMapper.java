package fi.joufa.safetor.team.service.mapper;

import fi.joufa.safetor.team.service.entity.TeamEntity;
import fi.joufa.safetor.teams.domain.Team;
import fi.joufa.safetor.teams.domain.TeamId;
import org.springframework.stereotype.Component;

@Component
public class TeamEntityMapper {

    public Team teamEntityToTeam(TeamEntity teamEntity) {
        return new Team(new TeamId(teamEntity.getId()), teamEntity.getName());
    }

    public TeamEntity teamToTeamEntity(final Team team) {
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setId(team.getId().getId());
        teamEntity.setName(team.getName());
        return teamEntity;
    }
}
