package KarateClub.iservice;

import java.util.List;

import org.springframework.stereotype.Service;

import KarateClub.dto.AppointmentDTO;
import KarateClub.dto.AppointmentRegisteredUserDTO;
import KarateClub.model.Appointment;

@Service
public interface IAppointmentService {

	Appointment createPredefinedAppointment(AppointmentDTO appointmentDTO) throws InterruptedException ;

	Appointment createAppointmentRegisteredUser(AppointmentRegisteredUserDTO appointmentRegisteredUserDTO);

	List<Appointment> findAllByCenterId(Long id);

	List<Appointment> findAllByRegisteredUserId(Long id);

	//Appointment schedulePredefinedAppointment(Long appointmentId, Long registeredUserId);
	
	List<Appointment> getAll();
	
	Appointment findById(Long appointmentId);
	
	Appointment cancelScheduledAppointment(Long appointmentId);
	
	List<Appointment> getAllAppointmentsByAdministratorId(Long centerAdministratorId); 

}
