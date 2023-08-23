package KarateClub.repository;

import KarateClub.model.Medal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedalRepository extends JpaRepository<Medal,Long> {
}
