package KarateClub.controller;

import java.util.List;

import KarateClub.exception.ResourceConflictException;
import KarateClub.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import KarateClub.dto.ChangePasswordDTO;
import KarateClub.dto.UserRegistrationDTO;
import KarateClub.dto.UserUpdateDTO;
import KarateClub.model.User;
import KarateClub.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping(value = "/registerUser")
	public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO,
			UriComponentsBuilder uriComponentsBuilder) {
		User existUser = this.userService.findByEmail(userRegistrationDTO.getEmail());
		if (existUser != null) {
			throw new ResourceConflictException(userRegistrationDTO.getEmail(), "Email already exists");
		}
		try {
			return new ResponseEntity<>(userService.registerUser(userRegistrationDTO), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping(value = "/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<List<Student>>(userService.getAllStudents(), HttpStatus.OK);
	}
	@GetMapping(value = "/getAllCoaches")
	public ResponseEntity<List<User>> getAllCoaches() {
		return new ResponseEntity<List<User>>(userService.getAllCoaches(), HttpStatus.OK);
	}

	//@PreAuthorize("hasRole('ROLE_REGISTERED_USER')")
	@PutMapping(value = "/update")
	public @ResponseBody UserUpdateDTO update(@RequestBody UserUpdateDTO u) {
		return userService.updateUser(u);
	}

	@GetMapping(value = "/getUserById/{userId}")
	public User loadById(@PathVariable Long userId) {
		return this.userService.findById(userId);
	}

	@GetMapping(value = "/getUserByEmail/{email}")
	public User findById(@PathVariable String email) {
		return this.userService.findByEmail(email);
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.PUT)
	public @ResponseBody User changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
		return userService.changePassword(changePasswordDTO);
	}

	@GetMapping(value = "/findUserByNameAndSurnameForSystemAdmin/{name}/{surname}")
	public ResponseEntity<List<User>> findUserByNameAndSurname(@PathVariable String name,
			@PathVariable String surname) {
		return new ResponseEntity<List<User>>(userService.findUserByNameAndSurnameForSystemAdmin(name, surname),
				HttpStatus.OK);
	}

	@GetMapping(value = "/findUserByNameAndSurnameForCenterAdmin/{name}/{surname}")
	public ResponseEntity<List<User>> findUserByNameAndSurnameForCenterAdmin(@PathVariable String name,
			@PathVariable String surname) {
		return new ResponseEntity<List<User>>(userService.findUserByNameAndSurnameForCenterAdmin(name, surname),
				HttpStatus.OK);
	}

	@GetMapping(value = "/checkPenalties/{id}/{present}")
	public ResponseEntity<?> checkPenalties(@PathVariable Long id, @PathVariable String present) {
//			return new ResponseEntity<List<User>>(userService.findUserByNameAndSurnameForCenterAdmin(name, surname), HttpStatus.OK);
		String comp = "NO";
		if (present.equals(comp)) {
			// ovde nije dosao
			userService.updatePenal(id);
			String ret = "Penalties well refreshed!";
			return new ResponseEntity<>(ret, HttpStatus.BAD_REQUEST);
		} else {

			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@GetMapping(value = "/getStudentsInGroup/{groupId}")
	public ResponseEntity<List<Student>> getStudentsInGroup(@PathVariable Long groupId) {
		return new ResponseEntity<List<Student>>(userService.getStudentsInGroup(groupId), HttpStatus.OK);
	}

}
