package KarateClub.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ReportCenterDTO {

	@NotNull
	private Long patientId;

	@NotBlank
	private String patientName;

	@NotBlank
	private String patientSurname;

	@NotBlank
	private double quantaty;

	@NotBlank
	private String blood;

	@NotBlank
	private String date;

	public ReportCenterDTO() {
	}

	public ReportCenterDTO(Long patientId, String patientName, String patientSurname, double quantaty, String blood,
			String date) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientSurname = patientSurname;
		this.quantaty = quantaty;
		this.blood = blood;
		this.date = date;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientSurname() {
		return patientSurname;
	}

	public void setPatientSurname(String patientSurname) {
		this.patientSurname = patientSurname;
	}

	public double getQuantaty() {
		return quantaty;
	}

	public void setQuantaty(double quantaty) {
		this.quantaty = quantaty;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
