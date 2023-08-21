package KarateClub.service;

import KarateClub.dto.CompetitionDTO;
import KarateClub.dto.DisciplineDTO;
import KarateClub.iservice.ICompetitionService;
import KarateClub.model.*;
import KarateClub.repository.ICompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    public CompetitionService(ICompetitionRepository competitionRepository, KarateClubService karateClubService,
                              UserService userService, DisciplineService disciplineService){
        super();
        this.competitionRepository = competitionRepository;
        this.karateClubService = karateClubService;
        this.userService = userService;
        this.disciplineService = disciplineService;
    }
    @Override
    public List<CompetitionDTO> getAllCompetitions() {
        return competitionRepository.findAll().stream().map(competition -> new CompetitionDTO(competition)).collect(Collectors.toList());
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

//    @Override
//    public Page<CompetitionDTO> findAll(Pageable pageable) {
//        return (Page<CompetitionDTO>) competitionRepository.findAll(pageable).stream().map(competition -> new CompetitionDTO(competition)).collect(Collectors.toList());
//    }
}
