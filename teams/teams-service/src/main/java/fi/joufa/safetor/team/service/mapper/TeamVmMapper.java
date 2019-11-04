package fi.joufa.safetor.team.service.mapper;

import fi.joufa.safetor.team.service.domain.DomainFactory;
import fi.joufa.safetor.team.service.web.rest.TeamVM;
import fi.joufa.safetor.teams.domain.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamVmMapper {
  public TeamVM toVM(final Team team) {
    final TeamVM teamVM = new TeamVM();
    teamVM.setId(team.getId().getId());
    teamVM.setName(team.getName());
    return teamVM;
  }

  public Team toTeam(final TeamVM teamVM) {
    return DomainFactory.create(teamVM.getId(), teamVM.getName());
  }
}
