package fi.joufa.safetor.teams.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeamTest {


    @Test
    public void createNewTeam() {
        final Team team = new Team(new TeamId(Long.valueOf(1)), "Test team");
        assertEquals("Test team", team.getName());
    }

    @Test
    public void createNullTeam() {
        final Team team = new Team(new TeamId(null), "Test");

    }
}