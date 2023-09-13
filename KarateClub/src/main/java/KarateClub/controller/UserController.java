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

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR')")
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

	@PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR')")
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR')")
	@GetMapping(value = "/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<List<Student>>(userService.getAllStudents(), HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR')")
	@GetMapping(value = "/getAllClubStudents/{clubId}")
	public ResponseEntity<List<Student>> getAllClubStudents(@PathVariable Long clubId) {
		return new ResponseEntity<List<Student>>(userService.getAllClubStudents(clubId), HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR')")
	@GetMapping(value = "/getAllCoaches")
	public ResponseEntity<List<User>> getAllCoaches() {
		return new ResponseEntity<List<User>>(userService.getAllCoaches(), HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR')")
	@GetMapping(value = "/getAllClubCoaches/{clubId}")
	public ResponseEntity<List<User>> getAllClubCoaches(@PathVariable Long clubId) {
		return new ResponseEntity<List<User>>(userService.getAllClubCoaches(clubId), HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR', 'ROLE_STUDENT')")
	@PutMapping(value = "/update")
	public @ResponseBody UserUpdateDTO update(@RequestBody UserUpdateDTO u) {
		return userService.updateUser(u);
	}

	@PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR', 'ROLE_STUDENT')")
	@GetMapping(value = "/getUserById/{userId}")
	public User loadById(@PathVariable Long userId) {
		return this.userService.findById(userId);
	}

	@PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR', 'ROLE_STUDENT')")
	@GetMapping(value = "/getUserByEmail/{email}")
	public User findById(@PathVariable String email) {
		return this.userService.findByEmail(email);
	}

	@PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR', 'ROLE_STUDENT')")
	@RequestMapping(value = "/changePassword", method = RequestMethod.PUT)
	public @ResponseBody User changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
		return userService.changePassword(changePasswordDTO);
	}

	@PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR')")
	@GetMapping(value = "/getStudentsInGroup/{groupId}")
	public ResponseEntity<List<Student>> getStudentsInGroup(@PathVariable Long groupId) {
		return new ResponseEntity<List<Student>>(userService.getStudentsInGroup(groupId), HttpStatus.OK);
	}

}
