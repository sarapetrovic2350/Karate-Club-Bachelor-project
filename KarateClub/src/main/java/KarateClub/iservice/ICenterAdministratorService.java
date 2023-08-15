package KarateClub.iservice;

import java.util.List;

import org.springframework.stereotype.Service;

import KarateClub.dto.CenterAdministratorRegistrationDTO;
import KarateClub.model.CenterAdministrator;

@Service
public interface ICenterAdministratorService {

	CenterAdministrator registerCenterAdministrator(
			CenterAdministratorRegistrationDTO centerAdministratorRegistrationDTO);

	List<CenterAdministrator> getAllCenterAdministrator();
}
