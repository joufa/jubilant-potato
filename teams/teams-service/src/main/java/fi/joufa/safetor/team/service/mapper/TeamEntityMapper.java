package fi.joufa.safetor.team.service.mapper;

import fi.joufa.safetor.team.service.entity.TeamEntity;
import fi.joufa.safetor.team.service.web.rest.TeamVM;
import fi.joufa.safetor.teams.domain.Team;
import fi.joufa.safetor.teams.domain.TeamId;
import org.springframework.stereotype.Component;

@Component
public class TeamEntityMapper {

  public Team teamEntityToTeam(TeamEntity teamEntity) {
    return new Team(new TeamId(teamEntity.getId()), teamEntity.getName());
  }

  public TeamEntity vmToEntity(final TeamVM teamVM) {
    TeamEntity entity = new TeamEntity();
    entity.setId(teamVM.getId());
    entity.setName(teamVM.getName());
    return entity;
  }

  public TeamVM entityToVm(final TeamEntity teamEntity) {
    TeamVM teamVM = new TeamVM();
    teamVM.setId(teamEntity.getId());
    teamVM.setName(teamEntity.getName());
    return teamVM;
  }
}
