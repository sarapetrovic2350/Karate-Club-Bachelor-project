package KarateClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import KarateClub.model.SystemAdministrator;

public interface ISystemAdministratorRepository extends JpaRepository<SystemAdministrator, Long>{

}
