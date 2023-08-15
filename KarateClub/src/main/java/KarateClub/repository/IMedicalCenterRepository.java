package KarateClub.repository;

import java.util.List;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import KarateClub.model.MedicalCenter;

@Repository
public interface IMedicalCenterRepository extends JpaRepository<MedicalCenter, Long>{
	
	Page<MedicalCenter> findAll(Pageable pageable);
	
//	@Query("SELECT mc FROM MedicalCenter mc WHERE mc.name=?1")
    List<MedicalCenter>findByName(String name);
	
	//@Query("SELECT mc FROM MedicalCenter mc, Address a WHERE mc.addressId=a.addressId and a.city=?1")
    List<MedicalCenter>findMedicalCentersByAddressCity(String city);

//	@Query("SELECT mc FROM MedicalCenter mc, Address a WHERE mc.addressId=a.addressId and mc.name=?1 and a.city=?2")
	List<MedicalCenter>findMedicalCentersByNameAndAddressCity(String name, String city);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select a from MedicalCenter a where a.id = :id")
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="0")})
    public MedicalCenter findOneById(@Param("id")Long id);
}
