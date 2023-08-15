package KarateClub.iservice;

import java.util.List;

import org.springframework.stereotype.Service;

import KarateClub.dto.SystemAdministratorRegistrationDTO;
import KarateClub.model.SystemAdministrator;

@Service
public interface ISystemAdministratorService {
	
	SystemAdministrator registerSystemAdministrator(
			SystemAdministratorRegistrationDTO systemAdministratorRegistrationDTO);

	List<SystemAdministrator> getAllSystemAdministrators();

}
