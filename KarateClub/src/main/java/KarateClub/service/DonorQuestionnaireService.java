package KarateClub.service;

import java.util.List;

import KarateClub.iservice.IDonorQuestionnaireService;
import KarateClub.repository.IDonorQuestionnaireRepository;
import KarateClub.repository.IUserRepository;
import org.springframework.stereotype.Service;

import KarateClub.dto.DonorQuestionnaireDTO;
import KarateClub.model.DonorQuestionnaire;
import KarateClub.model.RegisteredUser;

@Service
public class DonorQuestionnaireService implements IDonorQuestionnaireService {

	private IDonorQuestionnaireRepository donorQuestionnaireRepository;
	private IUserRepository userRepository;

	public DonorQuestionnaireService(IDonorQuestionnaireRepository donorQuestionnaireRepository,
			IUserRepository userRepository) {
		super();
		this.donorQuestionnaireRepository = donorQuestionnaireRepository;
		this.userRepository = userRepository;
	}

	@Override
	public DonorQuestionnaire saveQuestionnaire(DonorQuestionnaireDTO questionnaireDTO) {
		DonorQuestionnaire questionnaire = new DonorQuestionnaire();
		RegisteredUser u = (RegisteredUser) userRepository.findByEmail(questionnaireDTO.getUserEmail());
		DonorQuestionnaire existingQuestionnaireForUser = donorQuestionnaireRepository.findByRegisteredUserUserId(u.getUserId());
		if(existingQuestionnaireForUser != null) {
			questionnaire = existingQuestionnaireForUser;
		}
		questionnaire.setRegisteredUser(u);
		System.out.println(questionnaire.getRegisteredUser().getSurname().toString());
		questionnaire.setWeight(questionnaireDTO.getWeight());
		questionnaire.setAge(questionnaireDTO.getAge());
		questionnaire.setGeneralGoodHealth(questionnaireDTO.getGeneralGoodHealth());
		questionnaire.setSymptomsOfIllness(questionnaireDTO.getSymptomsOfIllness());
		questionnaire.setUnderMedication(questionnaireDTO.getUnderMedication());
		questionnaire.setNormalBloodPressure(questionnaireDTO.getNormalBloodPressure());
		questionnaire.setSkinDisorders(questionnaireDTO.getSkinDisorders());
		questionnaire.setTattooOrPiercing(questionnaireDTO.getTattooOrPiercing());
		questionnaire.setRecentlyVisitedDentist(questionnaireDTO.getRecentlyVisitedDentist());
		questionnaire.setRecentlyDonatedBlood(questionnaireDTO.getRecentlyDonatedBlood());
		questionnaire.setHasPeriod(questionnaireDTO.getHasPeriod());

		return donorQuestionnaireRepository.save(questionnaire);
	}

	@Override
	public List<DonorQuestionnaire> getAllQuestionnaires() {
		return donorQuestionnaireRepository.findAll();
	}

	public DonorQuestionnaire getQuestionnareByUserId(Long Id) {
		List<DonorQuestionnaire> list = getAllQuestionnaires(); 
		DonorQuestionnaire retVal = new DonorQuestionnaire(); 
		for(int i=0; i< list.size(); i++) {
			if(list.get(i).getRegisteredUser().getUserId().equals(Id)) {
				retVal = list.get(i); 
			}
		}
		
		return retVal; 
	}
	//INSERT INTO public.donor_questionnaire (id, age, general_good_health, has_period, normal_blood_pressure, recently_donated_blood, visited_dentist, skin_disorders, symptoms_of_illness, tattoo_or_piercing, under_medication, weight, user_id ) VALUES 
	//(default, '22', true, false, true, false, false, false, false, false, false, '56', '2' ); 
	public Boolean checkQuestionnare(Long Id) {
		
		DonorQuestionnaire questionnaire = getQuestionnareByUserId(Id); 
		
		if(questionnaire.getWeight() < 50) {
			return false; 
		}else if(questionnaire.getAge() < 18) {
			return false; 
		}else if(questionnaire.getGeneralGoodHealth().equals(false)) {
			return false; 
		}else if(questionnaire.getSymptomsOfIllness().equals(true)) {
			return false; 
		}else if(questionnaire.getNormalBloodPressure().equals(false)) {
			return false; 
		}else if(questionnaire.getSkinDisorders().equals(true)) {
			return false; 
		}else if(questionnaire.getUnderMedication().equals(true)) {
			return false; 
		}else if(questionnaire.getTattooOrPiercing().equals(true)){
			return false; 
		}else if(questionnaire.getRecentlyVisitedDentist().equals(true)){
			return false; 
		}else if(questionnaire.getRecentlyDonatedBlood().equals(true)){
			return false; 
		}else if(questionnaire.getHasPeriod().equals(true)){
			return false; 
		}
			
		return true; 
	}
}
