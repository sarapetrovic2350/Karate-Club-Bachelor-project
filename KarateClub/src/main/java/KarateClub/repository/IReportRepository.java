package KarateClub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import KarateClub.model.Report;

@Repository
public interface IReportRepository extends JpaRepository<Report, Long> {
	
	List<Report> findReportsByRegisteredUserUserId(Long id);
}
