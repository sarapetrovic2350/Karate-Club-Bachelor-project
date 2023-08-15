package KarateClub.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ScheduledAppointmentDTO {

	@NotNull
	private Long appointmentId;

	@NotBlank
	private Long registeredUserId;

	@NotBlank
	private String date;

	@NotBlank
	private String time;

	@NotBlank
	private String duration;

	@NotBlank
	private String medicalCenterName;

	public ScheduledAppointmentDTO() {
	}

	public ScheduledAppointmentDTO(Long appointmentId, Long registeredUserId, String date, String time, String duration,
			String medicalCenterName) {
		super();
		this.appointmentId = appointmentId;
		this.registeredUserId = registeredUserId;
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.medicalCenterName = medicalCenterName;
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Long getRegisteredUserId() {
		return registeredUserId;
	}

	public void setRegisteredUserId(Long registeredUserId) {
		this.registeredUserId = registeredUserId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getMedicalCenterName() {
		return medicalCenterName;
	}

	public void setMedicalCenterName(String medicalCenterName) {
		this.medicalCenterName = medicalCenterName;
	}

}
