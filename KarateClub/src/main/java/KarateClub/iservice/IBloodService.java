package KarateClub.iservice;

import java.util.List;

import org.springframework.stereotype.Service;

import KarateClub.dto.AddingBloodDTO;
import KarateClub.model.Blood;
import KarateClub.model.BloodType;

@Service
public interface IBloodService {
	List<Blood> getAllBlood();
	Blood addingBlood(AddingBloodDTO addingBloodDTO);
	List<Blood> getBloodsByCenterId(Long centerId); 
	Blood findBloodByTypeCenterId(BloodType bloodType, Long centerId); 
	
}
