package KarateClub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import KarateClub.dto.SystemAdministratorRegistrationDTO;
import KarateClub.model.SystemAdministrator;
import KarateClub.service.SystemAdministratorService;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(value = "/systemAdministrator", produces = MediaType.APPLICATION_JSON_VALUE)
public class SystemAdministratorController {
	
	private SystemAdministratorService systemAdministratorService;

	@Autowired
	public SystemAdministratorController(SystemAdministratorService systemAdministratorService) {
		super();
		this.systemAdministratorService = systemAdministratorService;
	}

	@PreAuthorize("hasRole('ROLE_SYSTEM_ADMINISTRATOR')")
	@PostMapping(value = "/registerSystemAdministrator")
	public ResponseEntity<?> registerSystemAdministrator(
			@RequestBody SystemAdministratorRegistrationDTO systemAdministratorRegistrationDTO,
			UriComponentsBuilder uriComponentsBuilder) {
		try {
			// add validations
			return new ResponseEntity<>(
					systemAdministratorService.registerSystemAdministrator(systemAdministratorRegistrationDTO),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_SYSTEM_ADMINISTRATOR')")
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<SystemAdministrator>> findAll() {
		return new ResponseEntity<List<SystemAdministrator>>(systemAdministratorService.getAllSystemAdministrators(),
				HttpStatus.OK);
	}

}
