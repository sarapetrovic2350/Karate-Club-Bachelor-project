package KarateClub.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import KarateClub.service.ConfirmationTokenService;
import KarateClub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KarateClub.model.ConfirmationToken;
import KarateClub.model.JwtAuthenticationRequest;
import KarateClub.model.TokenUtils;
import KarateClub.model.User;
import KarateClub.model.UserTokenState;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthentificationController {

	private TokenUtils tokenUtils;

	private UserService userService;

	private AuthenticationManager authenticationManager;

	private ConfirmationTokenService confirmationTokenService;

	@Autowired
	public AuthentificationController(TokenUtils tokenUtils, UserService userService,
			AuthenticationManager authenticationManager, ConfirmationTokenService confirmationTokenService) {
		super();
		this.tokenUtils = tokenUtils;
		this.userService = userService;
		this.authenticationManager = authenticationManager;
		this.confirmationTokenService = confirmationTokenService;
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR', 'ROLE_COACH', 'ROLE_STUDENT')")
	@GetMapping
	public ResponseEntity<User> getLoggedInUser() {
		return new ResponseEntity<User>(userService.findLoggedInUser(), HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<UserTokenState> login(@RequestBody JwtAuthenticationRequest authenticationRequest,
                                                HttpServletResponse response) {
		try {
			System.out.println(authenticationRequest.getEmail());
			System.out.println(authenticationRequest.getPassword());
			User logInUser = userService.login(authenticationRequest);
			System.out.println(logInUser.getName());
			System.out.println(logInUser);
			StringBuilder passwordWithSalt = new StringBuilder();
			passwordWithSalt.append(authenticationRequest.getPassword());
			passwordWithSalt.append(logInUser.getSalt());
			System.out.println(passwordWithSalt);
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getEmail(), passwordWithSalt.toString()));
			

			SecurityContextHolder.getContext().setAuthentication(authentication);
			User user = (User) authentication.getPrincipal();
			
			if (user.getEnabled()) {
				String jwt = tokenUtils.generateToken(authenticationRequest.getEmail());
				int expiresIn = tokenUtils.getExpiredIn();
				return ResponseEntity.ok(new UserTokenState(jwt, expiresIn, user));
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping(value = "/activate-account/{token}", consumes = "application/json")
	public ResponseEntity<Boolean> activateAccount(@PathVariable String token) {

		try {

			ConfirmationToken confirmationToken = confirmationTokenService.findByConfirmationToken(token);
			if (confirmationToken != null
					&& LocalDateTime.now().isBefore(confirmationToken.getCreatedDate().plusDays(5))) {
				User user = userService.findByEmail(confirmationToken.getUser().getEmail());
				System.out.println(user.toString());
				userService.activateAccount(user);
				
				return new ResponseEntity<>(HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
