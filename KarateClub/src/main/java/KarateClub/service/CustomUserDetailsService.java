package KarateClub.service;

import KarateClub.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import KarateClub.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

private IUserRepository userRepository;
	
	@Autowired
	public CustomUserDetailsService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User with email '%s' not found.", email));
		} else {
			return (UserDetails) user;
		}
	}
}
