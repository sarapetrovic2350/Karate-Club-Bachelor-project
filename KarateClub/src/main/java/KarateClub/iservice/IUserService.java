package KarateClub.iservice;

import java.util.List;

import KarateClub.model.Student;
import org.springframework.stereotype.Service;

import KarateClub.dto.UserRegistrationDTO;
import KarateClub.model.ConfirmationToken;
import KarateClub.model.JwtAuthenticationRequest;
import KarateClub.dto.UserUpdateDTO;
import KarateClub.model.User;

@Service
public interface IUserService {
	User registerUser(UserRegistrationDTO userRegistrationDTO);

	User login(JwtAuthenticationRequest authenticationRequest);

	List<User> getAllUsers();
	List<Student> getAllStudents();
	List<User> getAllCoaches();
	List<Student> getStudentsInGroup(Long groupId);

	User findLoggedInUser();

	User findById(Long id);
	
	UserUpdateDTO updateUser(UserUpdateDTO user);
	
	void sendConfirmationEmail(User user, ConfirmationToken confirmationToken);
}
