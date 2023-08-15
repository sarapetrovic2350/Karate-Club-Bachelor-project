package KarateClub.service;

import java.util.ArrayList;
import java.util.List;

import KarateClub.repository.IBloodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KarateClub.dto.AddingBloodDTO;
import KarateClub.iservice.IBloodService;
import KarateClub.model.Blood;
import KarateClub.model.BloodType;

@Service
public class BloodService implements IBloodService{
	
	private IBloodRepository bloodRepository;
	
	@Autowired
	public BloodService(IBloodRepository bloodRepository) {
		this.bloodRepository = bloodRepository;
	}

	@Override
	public List<Blood> getAllBlood() {
		// TODO Auto-generated method stub
		return bloodRepository.findAll();
	}

	@Override
	public Blood addingBlood(AddingBloodDTO addingBloodDTO) {
		Blood blood = findBloodByTypeCenterId(addingBloodDTO.getBloodType() ,addingBloodDTO.getCenterId());
		Double newQuantaty = blood.getQuantaty() + addingBloodDTO.getQuantaty(); 
		blood.setQuantaty(newQuantaty); 
		bloodRepository.save(blood); 
		return blood;
		//return null; 
	}

	@Override
	public List<Blood> getBloodsByCenterId(Long centerId) {

		List<Blood> bloodFinds = new ArrayList<Blood>();
		List<Blood> allBloods = getAllBlood();
		for (Blood blood : allBloods) {
			if(blood.getMedicalCenter().getCenterId().equals(centerId)) {
				bloodFinds.add(blood);
			}
		}
		return bloodFinds;
	}

	@Override
	public Blood findBloodByTypeCenterId(BloodType bloodType, Long centerId) {
		// TODO Auto-generated method stub
		Blood bloodRet = new Blood(); 
		List<Blood> allBloods = getAllBlood();
		for (Blood blood : allBloods) {
			if(blood.getMedicalCenter().getCenterId().equals(centerId) && blood.getBloodType().equals(bloodType)) {
				bloodRet = blood;
			}
		}
		return bloodRet;
	}


}
