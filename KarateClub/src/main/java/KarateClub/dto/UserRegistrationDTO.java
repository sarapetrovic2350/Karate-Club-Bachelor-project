package KarateClub.dto;

import javax.validation.constraints.NotBlank;

import KarateClub.model.*;
import lombok.Data;

@Data
public class UserRegistrationDTO {

	@NotBlank
	private String email;

	@NotBlank
	private String password;

	@NotBlank
	private String name;

	@NotBlank
	private String surname;

	@NotBlank
	private Address address;

	@NotBlank
	private String phoneNumber;

	@NotBlank
	private Gender gender;

	@NotBlank
	private String jmbg;

	@NotBlank
	private KarateClub karateClub;

	@NotBlank
	private UserType userType;
	
	@NotBlank
	private String licenceNumber;

	@NotBlank
	private BeltColor beltColor;

	@NotBlank
	private Group group;
}
