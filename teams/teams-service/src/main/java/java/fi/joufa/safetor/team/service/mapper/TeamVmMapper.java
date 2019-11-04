package java.fi.joufa.safetor.team.service.mapper;

import fi.joufa.safetor.teams.domain.Team;
import java.fi.joufa.safetor.team.service.domain.DomainFactory;
import java.fi.joufa.safetor.team.service.web.rest.TeamVM;
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
