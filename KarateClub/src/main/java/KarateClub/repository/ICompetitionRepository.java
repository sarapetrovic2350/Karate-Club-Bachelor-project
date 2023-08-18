package KarateClub.repository;

import KarateClub.model.Competition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompetitionRepository extends JpaRepository<Competition, Long> {

    Page<Competition> findAll(Pageable pageable);
    Competition findByCompetitionId(Long competitionId);

}
