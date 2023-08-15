package KarateClub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import KarateClub.model.DonorQuestionnaire;

@Repository
public interface IDonorQuestionnaireRepository extends JpaRepository<DonorQuestionnaire, Long> {
	
	DonorQuestionnaire findByRegisteredUserUserId(Long userId);
}
