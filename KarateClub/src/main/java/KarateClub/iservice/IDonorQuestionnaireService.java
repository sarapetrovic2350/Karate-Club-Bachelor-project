package KarateClub.iservice;

import java.util.List;

import org.springframework.stereotype.Service;

import KarateClub.dto.DonorQuestionnaireDTO;
import KarateClub.model.DonorQuestionnaire;

@Service
public interface IDonorQuestionnaireService {

	DonorQuestionnaire saveQuestionnaire(DonorQuestionnaireDTO questionnaireDTO);
	List<DonorQuestionnaire> getAllQuestionnaires();
}
