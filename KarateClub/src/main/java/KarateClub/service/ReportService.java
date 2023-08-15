package KarateClub.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import KarateClub.iservice.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KarateClub.dto.CreateReportDTO;
import KarateClub.model.Appointment;
import KarateClub.model.Blood;
import KarateClub.model.CenterAdministrator;
import KarateClub.model.RegisteredUser;
import KarateClub.model.Report;
import KarateClub.model.ReportStatus;
import KarateClub.repository.IAppointmentRepository;
import KarateClub.repository.IBloodRepository;
import KarateClub.repository.ICenterAdministratorRepository;
import KarateClub.repository.IReportRepository;
import KarateClub.repository.IUserRepository;

@Service
public class ReportService implements IReportService {

	private IReportRepository reportRepository;
	private IUserRepository userRepository;
	private ICenterAdministratorRepository centerAdministratorRepository;
	private IBloodRepository bloodRepository;
	private IAppointmentRepository appointmentsRepository;
	private BloodService bloodService; 
	
	@Autowired
	public ReportService(IReportRepository reportRepository, IUserRepository userRepository, ICenterAdministratorRepository centerAdministratorRepository, 
			IBloodRepository bloodRepository, IAppointmentRepository appointmentsRepository, BloodService bloodService) {
		this.reportRepository = reportRepository;
		this.userRepository = userRepository; 
		this.centerAdministratorRepository = centerAdministratorRepository; 
		this.bloodRepository = bloodRepository; 
		this.appointmentsRepository = appointmentsRepository; 
		this.bloodService = bloodService; 
	}

	@Override
	public Report save(CreateReportDTO report) {
		
		Report rep= new Report(); 
		
		System.out.println(report.getAdministratorEmail());
		System.out.println(report.getCustomerId());
		
		CenterAdministrator centAdmi = (CenterAdministrator) centerAdministratorRepository.findByEmail(report.getAdministratorEmail());
		rep.setCenterAdministrator(centAdmi); 
		RegisteredUser user = (RegisteredUser) userRepository.findByUserId(report.getCustomerId()); 
		rep.setRegisteredUser(user); 
//		Blood blood = bloodRepository.findById(report.getBloodId()).get(); 
//		rep.setBlood(blood); 
		Appointment appointment = (Appointment) appointmentsRepository.findById(report.getAppointmentId()).get(); 
		rep.setAppointment(appointment); 
		
		rep.setHaemoglobinValue(report.getHaemoglobinValue());
		rep.setHeart(report.getHeart()); 
		rep.setLungs(report.getLungs()); 
		rep.setWeight(report.getWeight()); 
		rep.setHeight(report.getHeight()); 
		//rep.setBloodPreasure(report.getBloodPreasure());
		rep.setBloodPreasure(90.0); 
		rep.setReportStatus(report.getReportStatus());  
		
		if(report.getReportStatus() == ReportStatus.ACCEPTED ) {	
			Blood blood = bloodService.findBloodByTypeCenterId(report.getBloodType(), centAdmi.getMedicalCenter().getCenterId()); 
			rep.setBlood(blood); 
			rep.setQuantaty(report.getQuantaty());
			rep.setReasonForDenying("Krv je primljena"); 
		}else {
			rep.setReasonForDenying(report.getReason());
		} 
		LocalDateTime lt = LocalDateTime.now();
		rep.setDate(lt); 	
		
		System.out.println(rep.getCenterAdministrator());
		System.out.println(rep.getQuantaty());
		
		return reportRepository.save(rep);
	}

	@Override
	public List<Report> getAll() {
		return reportRepository.findAll();
	}

	@Override
	public List<Report> getAllReportsByMedicalCenterId(Long id) {
		List<Report> listReports = new ArrayList<Report>(); 
		listReports = getAll(); 
		List<Report> retVal = new ArrayList<Report>();
		for(Report report : listReports) {
			if(report.getCenterAdministrator().getMedicalCenter().getCenterId().equals(id)) {
				retVal.add(report); 
			}
		}
		return retVal;
	}
	
	public List<Report> findAllByRegisteredUserId(Long id) {
		return reportRepository.findReportsByRegisteredUserUserId(id);
	} 
	
}
