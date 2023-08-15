package KarateClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import KarateClub.model.Authority;

@Repository
public interface IAuthorityRepository extends JpaRepository<Authority, Long> {

	Authority findByName(String name);
}
