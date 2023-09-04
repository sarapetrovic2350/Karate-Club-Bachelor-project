package KarateClub.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import KarateClub.model.Address;
import KarateClub.model.Gender;
import KarateClub.model.UserType;
import lombok.Data;

@Data
public class UserUpdateDTO {

	@NotNull
	private long userId;

	@NotBlank
	private String email;

	@NotBlank
	private String password;

	@NotBlank
	private UserType userType;

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
	private Long jmbg;

	@NotBlank
	private Double weight;

}
