package fi.joufa.safetor.teams.domain;

import java.util.Objects;

public class Team {
    private final TeamId id;
    private final String name;

    public Team(TeamId id, String name) {
        this.id = id;
        this.name = name;
    }

    public TeamId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id.equals(team.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
