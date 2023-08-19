package KarateClub.repository;

import KarateClub.model.Competition;
import KarateClub.model.KarateClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKarateClubRepository extends JpaRepository<KarateClub, Long> {
    KarateClub findByClubId(Long clubId);
}
