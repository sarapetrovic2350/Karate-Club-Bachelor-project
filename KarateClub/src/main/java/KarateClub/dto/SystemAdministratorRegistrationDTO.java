package KarateClub.dto;

import javax.validation.constraints.NotBlank;

import KarateClub.model.Address;
import KarateClub.model.Gender;
import KarateClub.model.Occupation;

public class SystemAdministratorRegistrationDTO {
	
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
	private Long jmbg;

	@NotBlank
	private Occupation occupation;

	@NotBlank
	private String occupationInfo;
	
	public SystemAdministratorRegistrationDTO() {
		
	}
	

	public SystemAdministratorRegistrationDTO(String email, String password, String name, String surname,
			Address address, String phoneNumber, Gender gender, Long jmbg, Occupation occupation, String occupationInfo) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.jmbg = jmbg;
		this.occupation = occupation;
		this.occupationInfo = occupationInfo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Long getJmbg() {
		return jmbg;
	}

	public void setJmbg(Long jmbg) {
		this.jmbg = jmbg;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	public String getOccupationInfo() {
		return occupationInfo;
	}

	public void setOccupationInfo(String occupationInfo) {
		this.occupationInfo = occupationInfo;
	}

	

}
