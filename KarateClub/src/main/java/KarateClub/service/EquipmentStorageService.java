package KarateClub.service;

import java.util.List;

import KarateClub.iservice.IEquipmentStorageService;
import KarateClub.repository.IEquipmentStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KarateClub.model.EquipmentStorage;

@Service
public class EquipmentStorageService  implements IEquipmentStorageService {
	
	private IEquipmentStorageRepository equipmentStorageRepository;
	
	@Autowired
	public EquipmentStorageService(IEquipmentStorageRepository equipmentStorageRepository) {
		super();
		this.equipmentStorageRepository = equipmentStorageRepository;
	}

	@Override
	public void updateQuantaty(Long centerId, Double qunataty) {
		// TODO Auto-generated method stub
		EquipmentStorage equipment = findEquipmentByCenterId(centerId); 
		Double quantaty = equipment.getQuantaty() - qunataty; 
		equipment.setQuantaty(quantaty); 
		equipmentStorageRepository.save(equipment); 
		
	}

	@Override
	public List<EquipmentStorage> getAll() {
		return equipmentStorageRepository.findAll();
	}
	
	@Override
	public EquipmentStorage findEquipmentByCenterId(Long Id) {
		List<EquipmentStorage> list = getAll(); 
		for(int i =0; i<list.size(); i++) {
			if(list.get(i).getMedicalCenter().getCenterId().equals(Id)) {
				return list.get(i); 
			}
		}
		return null; 
	}
	
}
