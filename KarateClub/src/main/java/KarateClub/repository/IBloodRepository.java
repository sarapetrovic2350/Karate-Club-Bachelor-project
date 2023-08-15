package KarateClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import KarateClub.model.Blood;

@Repository
public interface IBloodRepository extends JpaRepository<Blood, Long> {

}
