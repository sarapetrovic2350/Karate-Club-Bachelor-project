package KarateClub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import KarateClub.model.CenterAdministrator;

@Repository
public interface ICenterAdministratorRepository extends JpaRepository<CenterAdministrator, Long> {
	
	CenterAdministrator findByEmail(String email);
	List<CenterAdministrator> findCenterAdministratorsByMedicalCenterCenterId(Long id);
}
