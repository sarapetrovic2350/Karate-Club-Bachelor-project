package KarateClub.service;

import KarateClub.dto.*;
import KarateClub.iservice.ICompetitionService;
import KarateClub.model.*;
import KarateClub.repository.ICompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CompetitionService implements ICompetitionService {
    private ICompetitionRepository competitionRepository;
    private KarateClubService karateClubService;
    private UserService userService;
    private DisciplineService disciplineService;
    private MedalService medalService;

    @Autowired
    public CompetitionService(ICompetitionRepository competitionRepository, KarateClubService karateClubService,
                              UserService userService, DisciplineService disciplineService, MedalService medalService){
        super();
        this.competitionRepository = competitionRepository;
        this.karateClubService = karateClubService;
        this.userService = userService;
        this.disciplineService = disciplineService;
        this.medalService = medalService;
    }
    @Override
    public List<CompetitionDTO> getAllCompetitions() {
        return competitionRepository.findAll().stream().map(competition -> new CompetitionDTO(competition)).collect(Collectors.toList());
    }
    @Override
    public List<CompetitionDTO> getUpcomingCompetitions() {
        List<CompetitionDTO> allCompetitions = this.getAllCompetitions();
        List<CompetitionDTO> upcomingCompetitions = new ArrayList<>();
        for (CompetitionDTO competitionDTO: allCompetitions) {
            if(competitionDTO.getDate().isAfter(LocalDate.now())){
                upcomingCompetitions.add(competitionDTO);
            }
        }
        return upcomingCompetitions;
    }

    @Override
    public List<CompetitionDTO> getClubIsRegisteredToCompetitions(Long clubId) {
        List<Competition> allCompetitions = competitionRepository.findAll();
        List<Competition> competitionsClubIsRegisteredTo = new ArrayList<>();
        KarateClub club = karateClubService.findById(clubId);
        for (Competition competition: allCompetitions) {
            for (KarateClub karateClub: competition.getRegisteredClubs()){
                if(karateClub == club) {
                    competitionsClubIsRegisteredTo.add(competition);
                    break;
                }
            }
        }
        return competitionsClubIsRegisteredTo.stream().map(competition -> new CompetitionDTO(competition)).collect(Collectors.toList());

    }

    @Override
    public Competition findById(Long id) {
        return competitionRepository.findByCompetitionId(id);
    }

    @Override
    @Transactional
    public void registerClubToCompetition(Long competitionId, Long clubId) {
        KarateClub karateClub = karateClubService.findById(clubId);
        Competition competition = competitionRepository.findByCompetitionId(competitionId);
        competition.getRegisteredClubs().add(karateClub);
        competitionRepository.save(competition);
    }

    @Override
    public Boolean checkIfClubIsRegisteredToCompetition(Long competitionId, Long clubId) {
        Competition competition = competitionRepository.findByCompetitionId(competitionId);
        KarateClub karateClub = karateClubService.findById(clubId);
        Set<KarateClub> registeredClubs = competition.getRegisteredClubs();
        for(KarateClub registeredClub : registeredClubs) {
            if(registeredClub == karateClub)
                return true;
        }
        return false;
    }

    @Override
    public List<DisciplineDTO> getDisciplinesForCompetition(Long competitionId) {
        Competition competition = competitionRepository.findByCompetitionId(competitionId);
        return competition.getDisciplines().stream().map(discipline -> new DisciplineDTO(discipline)).collect(Collectors.toList());
    }

    @Override
    public DisciplineDTO findDisciplineByCompetitionDisciplineId(Long competitionId, Long disciplineId) {
        Competition competition = competitionRepository.findByCompetitionId(competitionId);
        Set<Discipline> disciplines = competition.getDisciplines();
        for(Discipline discipline: disciplines) {
            if(Objects.equals(discipline.getDisciplineId(), disciplineId)) {
                return new DisciplineDTO(discipline);
            }
        }
        return null;
    }

    @Override
    public DisciplineDTO registerStudentToDisciplineForCompetition(Long competitionId, Long disciplineId, Long userId) {
        Competition competition = competitionRepository.findByCompetitionId(competitionId);
        Student student = (Student) userService.findById(userId);
        Set<Discipline> disciplinesForCompetition = competition.getDisciplines();
        for (Discipline discipline: disciplinesForCompetition) {
            if(Objects.equals(discipline.getDisciplineId(), disciplineId)) {
                discipline.getRegisteredStudents().add(student);
                disciplineService.save(discipline);
                return new DisciplineDTO(discipline);
            }
        }
        return null;
    }

    @Override
    public List<DisciplineCompetitionDTO> getDisciplinesOfCompetitionForStudent(Long userId) {
        User user = userService.findById(userId);
        List<DisciplineDTO> disciplineDTOSForStudent = disciplineService.getDisciplinesStudentIsRegisteredTo(userId);
        List<Competition> allCompetitions = competitionRepository.findAll();
        List<DisciplineCompetitionDTO> disciplineCompetitionDTOS = new ArrayList<>();
        for (Competition competition: allCompetitions) {
            Set<Discipline> disciplines = competition.getDisciplines();
            for(Discipline discipline: disciplines) {
                for (DisciplineDTO disciplineDTO: disciplineDTOSForStudent) {
                    if(Objects.equals(disciplineDTO.getDisciplineId(), discipline.getDisciplineId()) && competition.getDate().isAfter(LocalDate.now())){
                        DisciplineCompetitionDTO disciplineCompetitionDTO = new DisciplineCompetitionDTO(competition, discipline);
                        disciplineCompetitionDTOS.add(disciplineCompetitionDTO);
                    }
                }
            }
        }
        return disciplineCompetitionDTOS;
    }

    public List<Competition> findCompetitionsForClub(Long clubId) {
        List<Competition> allCompetitions = competitionRepository.findAll();
        List<Competition> competitionsForClub = new ArrayList<>();
        for(Competition competition: allCompetitions) {
            if (competition.getDate().isAfter(LocalDate.now())) {
                for (KarateClub karateClub : competition.getRegisteredClubs()) {
                    if (Objects.equals(karateClub.getClubId(), clubId)) {
                        competitionsForClub.add(competition);
                    }

                }
            }
        }
        return competitionsForClub;
    }
    @Override
    public List<CompetitionRegisteredStudentsDTO> getCompetitionsDisciplinesWithRegisteredStudents(Long clubId) {
        List<Competition> competitionsForClub = this.findCompetitionsForClub(clubId);
        List<Discipline> disciplines = disciplineService.getDisciplinesWhichHaveRegisteredUsers();
        List<CompetitionRegisteredStudentsDTO> competitionRegisteredStudentsDTOS = new ArrayList<>();
        for (Discipline discipline: disciplines) {
            for (Competition competition: competitionsForClub) {
                if (competition.getDate().isAfter(LocalDate.now())) {
                    Set<Discipline> disciplineSet = competition.getDisciplines();
                    for(Discipline discipline1: disciplineSet) {
                        if(discipline1 == discipline) {
                            List<StudentGroupDTO> studentGroupDTOS = new ArrayList<>();
                            boolean disciplineForClub = false;
                            for(Student student: discipline.getRegisteredStudents()){
                                if(Objects.equals(student.getKarateClub().getClubId(), clubId)) {
                                    disciplineForClub = true;
                                }
                                StudentGroupDTO studentGroupDTO = new StudentGroupDTO(student, student.getGroup(), student.getGroup().getCoach());
                                studentGroupDTOS.add(studentGroupDTO);
                            }
                            if(disciplineForClub) {
                                CompetitionRegisteredStudentsDTO competitionRegisteredStudentsDTO = new CompetitionRegisteredStudentsDTO(competition, discipline, studentGroupDTOS);
                                competitionRegisteredStudentsDTOS.add(competitionRegisteredStudentsDTO);
                            }
                        }
                    }
                }
            }
        }
        return competitionRegisteredStudentsDTOS;
    }

    @Override
    public List<CompetitionMedalDTO> getCompetitionMedalsForKarateClub(Long clubId) {
        List<MedalDisciplineDTO> medals = medalService.getAllMedals();
        List<Competition> allCompetitions = competitionRepository.findAll();
        List<CompetitionMedalDTO> competitionMedalDTOS = new ArrayList<>();
        for (Competition competition: allCompetitions) {
            Set<Discipline> disciplines = competition.getDisciplines();
            for(Discipline discipline: disciplines) {
                for (MedalDisciplineDTO medalDisciplineDTO: medals) {
                    if(Objects.equals(medalDisciplineDTO.getDisciplineId(), discipline.getDisciplineId()) && Objects.equals(medalDisciplineDTO.getStudentClubId(), clubId)) {
                        CompetitionMedalDTO competitionMedalDTO = new CompetitionMedalDTO(competition, medalDisciplineDTO);
                        competitionMedalDTOS.add(competitionMedalDTO);
                    }
                }

            }
        }
        return competitionMedalDTOS;

    }

//    @Override
//    public Page<CompetitionDTO> findAll(Pageable pageable) {
//        return (Page<CompetitionDTO>) competitionRepository.findAll(pageable).stream().map(competition -> new CompetitionDTO(competition)).collect(Collectors.toList());
//    }
}
