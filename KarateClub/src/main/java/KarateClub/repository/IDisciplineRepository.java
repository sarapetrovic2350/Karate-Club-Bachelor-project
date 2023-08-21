package KarateClub.repository;

import KarateClub.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDisciplineRepository extends JpaRepository<Discipline, Long> {
}
