package KarateClub.repository;

import KarateClub.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompetitionRepository extends JpaRepository<Competition, Long> {
    Competition findByCompetitionId(Long competitionId);
}
