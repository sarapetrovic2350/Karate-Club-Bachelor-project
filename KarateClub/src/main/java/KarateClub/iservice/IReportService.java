package KarateClub.iservice;

import java.util.List;

import org.springframework.stereotype.Service;

import KarateClub.dto.CreateReportDTO;
import KarateClub.model.Report;

@Service
public interface IReportService {
	
	Report save(CreateReportDTO report); 
	List<Report> getAll();
	List<Report> getAllReportsByMedicalCenterId(Long id); 
}
