package KarateClub.iservice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import KarateClub.model.MedicalCenter;

@Service
public interface IMedicalCenterService {

	MedicalCenter save(MedicalCenter medicalCenter);

	// MedicalCenter update(MedicalCenter medicalCenter);
	List<MedicalCenter> getAll();
	
	Page<MedicalCenter> findAll(Pageable pageable);
	Page<MedicalCenter> findAllOrderByNameAsc(Pageable pageable);
	Page<MedicalCenter> findAllOrderByAverageGradeDesc(Pageable pageable);
	Page<MedicalCenter> findAllOrderByCityNameAsc(Pageable pageable);
	
	
	
}
