package KarateClub.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import KarateClub.iservice.IUserService;
import KarateClub.model.*;
import KarateClub.repository.IUserRepository;
import KarateClub.repository.RegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import KarateClub.dto.ChangePasswordDTO;
import KarateClub.dto.UserRegistrationDTO;
import KarateClub.dto.UserUpdateDTO;

@Service
@EnableScheduling
public class UserService implements IUserService {

	private IUserRepository userRepository;
	private GroupService groupService;

	private AuthorityService authorityService;

	private ConfirmationTokenService confirmationTokenService;

	private EmailService emailService;

	private RegisteredUserRepository registeredUserRepository;

	@Autowired
	public UserService(IUserRepository userRepository, GroupService groupService, AuthorityService authorityService,
					   ConfirmationTokenService confirmationTokenService, EmailService emailService,
					   RegisteredUserRepository registeredUserRepository) {
		super();
		this.userRepository = userRepository;
		this.groupService = groupService;
		this.authorityService = authorityService;
		this.confirmationTokenService = confirmationTokenService;
		this.emailService = emailService;
		this.registeredUserRepository = registeredUserRepository;

	}

	@Override
	public User registerUser(UserRegistrationDTO userRegistrationDTO) {
		if (userRegistrationDTO.getUserType().equals(UserType.COACH)) {
			return this.registerCoach(userRegistrationDTO);
		} else {
			return this.registerStudent(userRegistrationDTO);
		}
	}

	public User registerCoach(UserRegistrationDTO userRegistrationDTO) {
		Coach coach = new Coach();
		coach.setEmail(userRegistrationDTO.getEmail());
		byte[] salt = generateSalt();
		String encodedSalt = Base64.getEncoder().encodeToString(salt);
		coach.setSalt(encodedSalt);
		String passwordWithSalt = generatePasswordWithSalt(userRegistrationDTO.getPassword(), encodedSalt);
		String securePassword = hashPassword(passwordWithSalt);
		coach.setPassword(securePassword);
		coach.setName(userRegistrationDTO.getName());
		coach.setSurname(userRegistrationDTO.getSurname());
		coach.setAddress(userRegistrationDTO.getAddress());
		coach.setPhoneNumber(userRegistrationDTO.getPhoneNumber());
		coach.setJmbg(Long.parseLong(userRegistrationDTO.getJmbg()));
		coach.setGender(userRegistrationDTO.getGender());
		coach.setUserType(userRegistrationDTO.getUserType());
		Authority authority = authorityService.findByName("COACH");
		coach.setAuthority(authority);
		coach.setLicenceNumber(userRegistrationDTO.getLicenceNumber());
		coach.setKarateClub(userRegistrationDTO.getKarateClub());
		coach.setEnabled(true);
		userRepository.save(coach);
		if (userRegistrationDTO.getGroupId() != null) {
			Group group = this.groupService.findById(userRegistrationDTO.getGroupId());
			group.setCoach(coach);
			groupService.saveGroupWithCoach(group);
		}
		ConfirmationToken confirmationToken = confirmationTokenService.saveConfirmationToken(coach);
		//sendConfirmationEmail(registeredUser, confirmationToken);
		return coach;
	}

	public User registerStudent(UserRegistrationDTO userRegistrationDTO) {
		Student student = new Student();
		student.setEmail(userRegistrationDTO.getEmail());
		byte[] salt = generateSalt();
		String encodedSalt = Base64.getEncoder().encodeToString(salt);
		student.setSalt(encodedSalt);
		String passwordWithSalt = generatePasswordWithSalt(userRegistrationDTO.getPassword(), encodedSalt);
		String securePassword = hashPassword(passwordWithSalt);
		student.setPassword(securePassword);
		student.setName(userRegistrationDTO.getName());
		student.setSurname(userRegistrationDTO.getSurname());
		student.setAddress(userRegistrationDTO.getAddress());
		student.setPhoneNumber(userRegistrationDTO.getPhoneNumber());
		student.setJmbg(Long.parseLong(userRegistrationDTO.getJmbg()));
		student.setGender(userRegistrationDTO.getGender());
		student.setUserType(userRegistrationDTO.getUserType());
		student.setKarateClub(userRegistrationDTO.getKarateClub());
		student.setBeltColor(userRegistrationDTO.getBeltColor());
		Group group = this.groupService.findById(userRegistrationDTO.getGroupId());
		student.setGroup(group);
		Authority authority = authorityService.findByName("STUDENT");
		student.setAuthority(authority);
		student.setEnabled(true);
		userRepository.save(student);
		ConfirmationToken confirmationToken = confirmationTokenService.saveConfirmationToken(student);
		//sendConfirmationEmail(registeredUser, confirmationToken);
		return student;
	}

	@Override
	public User login(JwtAuthenticationRequest authenticationRequest) {
		User user = findByEmail(authenticationRequest.getEmail());
		if (user != null)
			if (verifyHash(generatePasswordWithSalt(authenticationRequest.getPassword(), user.getSalt()),
					user.getPassword()))
				return user;

		return null;
	}

	private static byte[] generateSalt() {
		SecureRandom random = new SecureRandom();
		byte[] genSalt = new byte[16];
		random.nextBytes(genSalt);
		return genSalt;
	}

	private String generatePasswordWithSalt(String userPassword, String salt) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(userPassword);
		stringBuilder.append(salt);
		return stringBuilder.toString();
	}

	public String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}

	public boolean verifyHash(String password, String hash) {
		return BCrypt.checkpw(password, hash);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	@Override
	public List<Student> getAllStudents() {

		List<User> allUsers = userRepository.findAll();
		List<Student> students = new ArrayList<>();
		for (User user : allUsers) {
			if (user.getUserType().equals(UserType.STUDENT)) {
				students.add((Student) user);
			}
		}

		return students;
	}
	@Override
	public List<User> getAllCoaches() {

		List<User> allUsers = userRepository.findAll();
		List<User> coaches = new ArrayList<>();
		for (User user : allUsers) {
			if (user.getUserType().equals(UserType.COACH)) {
				coaches.add(user);
			}
		}

		return coaches;
	}

	public User findById(Long id) throws AccessDeniedException {
		User u = userRepository.findById(id).orElseGet(null);
		return u;
	}

	public UserUpdateDTO updateUser(UserUpdateDTO user) {
		User updatedUser = userRepository.findById(user.getUserId()).get();
		updatedUser.setName(user.getName());
		updatedUser.setSurname(user.getSurname());
		updatedUser.setEmail(user.getEmail());
		//updatedUser.setPassword(user.getPassword());
		updatedUser.setAddress(user.getAddress());
		updatedUser.setPhoneNumber(user.getPhoneNumber());
		//updatedUser.setJmbg(user.getJmbg());
		updatedUser.setGender(user.getGender());
		this.userRepository.save(updatedUser);
		return user;
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findLoggedInUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userRepository.findByUserId(user.getUserId());
	}

	public User changePassword(ChangePasswordDTO newPassword) {
		User user = findByEmail(newPassword.getEmail());
		checkInput(newPassword, user);
		generateNewSecurePassword(newPassword, user);
		return userRepository.save(user);
	}

	private void checkInput(ChangePasswordDTO changePasswordDTO, User user) {
		if (changePasswordDTO.getPassword().equals(changePasswordDTO.getOldPassword())) {
			throw new IllegalArgumentException("Password can not be the same as the old one.");
		}
		if (!changePasswordDTO.getPassword().equals(changePasswordDTO.getPasswordRepeated())) {
			throw new IllegalArgumentException("Passwords must match!");
		}
		if (changePasswordDTO.getPassword().isEmpty() || changePasswordDTO.getPasswordRepeated().isEmpty()
				|| changePasswordDTO.getOldPassword().isEmpty()) {
			throw new IllegalArgumentException("Fill all the required fields!");
		}

		String oldPassword = generatePasswordWithSalt(changePasswordDTO.getOldPassword(), user.getSalt());
		if (!verifyHash(oldPassword, user.getPassword())) {
			throw new IllegalArgumentException("Old password isn't correct!");
		}
	}

	private void generateNewSecurePassword(ChangePasswordDTO changePasswordDTO, User user) {
		byte[] salt = generateSalt();
		String encodedSalt = Base64.getEncoder().encodeToString(salt);
		user.setSalt(encodedSalt);
		String passwordWithSalt = generatePasswordWithSalt(changePasswordDTO.getPassword(), encodedSalt);
		String newSecurePassword = hashPassword(passwordWithSalt);
		user.setPassword(newSecurePassword);
	}

	public List<User> findUserByNameAndSurnameForSystemAdmin(String name, String surname) {
		List<User> usersFind = new ArrayList<User>();
		List<User> users = getAllUsers();
		for (User user : users) {
			if (name.equals("null") || surname.equals("null")) {
				if (user.getName().toLowerCase().contains(name.toLowerCase().trim())
						|| user.getSurname().toLowerCase().contains(surname.toLowerCase().trim()))
					usersFind.add(user);
			} else {
				if (user.getName().toLowerCase().contains(name.toLowerCase().trim())
						&& user.getSurname().toLowerCase().contains(surname.toLowerCase().trim()))
					usersFind.add(user);
			}
		}
		return usersFind;
	}

	public List<User> findUserByNameAndSurnameForCenterAdmin(String name, String surname) {
		List<User> usersFind = new ArrayList<User>();
		List<User> users = getAllUsers();
		for (User user : users) {
			if (name.equals("null") || surname.equals("null")) {
				if (user.getName().toLowerCase().contains(name.toLowerCase().trim())
						|| user.getSurname().toLowerCase().contains(surname.toLowerCase().trim()))
					usersFind.add(user);
			} else {
				if (user.getName().toLowerCase().contains(name.toLowerCase().trim())
						&& user.getSurname().toLowerCase().contains(surname.toLowerCase().trim()))
					usersFind.add(user);
			}
		}
		return usersFind;
	}

	public void updatePenal(Long id) {

		RegisteredUser user = (RegisteredUser) registeredUserRepository.findById(id).get();
		Integer pen = user.getPenalties();
		Integer penal = pen + 1;
		user.setPenalties(penal);
		registeredUserRepository.save(user);

	}

	@Scheduled(cron = "0 0 0 1 * ?")
	public void clearPenalties() {
		for (RegisteredUser registeredUser : registeredUserRepository.findAll()) {
			registeredUser.setPenalties(0);
			userRepository.save(registeredUser);
		}
	}

	/*
	 * public void checkDateToClearPenalties(Long registeredUserId) { //LocalDate
	 * startOfNextMonth = DateUtility.getStartOfNextMonth(); //LocalDate dt1 =
	 * LocalDate.parse("2023-02-04"); //if
	 * (LocalDate.now().compareTo(startOfNextMonth) < 0) { //return false; //}
	 * //RegisteredUser user = (RegisteredUser)
	 * registeredUserRepository.findById(id).get(); //user.setPenalties(0);
	 * //registeredUserRepository.save(user); //return true; }
	 */

	@Override
	public void sendConfirmationEmail(User user, ConfirmationToken confirmationToken) {
		System.out.println("User's email: " + user.getEmail());
		try {

			String recipientEmail = user.getEmail();
			String subject = "Confirm registration";
			String message = "Please activate your account by clicking the link below: \n\n"
					+ "http://localhost:4200/confirm-registration/" + confirmationToken.getConfirmationToken();
			emailService.sendNotificationAsync(recipientEmail, subject, message);
		} catch (Exception e) {
			System.out.println("Error sending email: " + e.getMessage());
		}

	}

	public void activateAccount(User user) {
		User existingUser = userRepository.findById(user.getUserId()).orElse(null);
		existingUser.setEnabled(true);
		userRepository.save(existingUser);
	}
	@Override
	public List<Student> getStudentsInGroup(Long groupId) {
		Group group = this.groupService.findById(groupId);
		List<Student> allStudents = getAllStudents();
		List<Student> studentsInGroup = new ArrayList<>();
		for(Student student: allStudents) {
			if(student.getGroup() == group) {
				studentsInGroup.add(student);
			}
		}
		return studentsInGroup;
	}

}