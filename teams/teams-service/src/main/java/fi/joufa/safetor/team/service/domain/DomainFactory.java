package fi.joufa.safetor.team.service.domain;

import fi.joufa.safetor.teams.domain.Team;
import fi.joufa.safetor.teams.domain.TeamId;

public class DomainFactory {

  public static Team create(final Long id, final String name) {
    if (id == null || name == null) {
      throw new IllegalArgumentException();
    }
    return new Team(new TeamId(id), name);
  }
}
