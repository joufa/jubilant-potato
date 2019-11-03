package fi.joufa.safetor.team.service.repository;

import fi.joufa.safetor.team.service.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
}
