package KarateClub.iservice;

import KarateClub.dto.*;
import KarateClub.model.Competition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICompetitionService {
    List<CompetitionDTO> getAllCompetitions();
    List<CompetitionDTO> getUpcomingCompetitions();
    List<CompetitionDTO> getClubIsRegisteredToCompetitions(Long clubId);
    //Page<CompetitionDTO> findAll(Pageable pageable);

    Competition findById(Long id);
    void registerClubToCompetition(Long competitionId, Long clubId);
    Boolean checkIfClubIsRegisteredToCompetition(Long competitionId, Long clubId);
    List<DisciplineDTO> getDisciplinesForCompetition(Long competitionId);
    DisciplineDTO findDisciplineByCompetitionDisciplineId(Long competitionId, Long disciplineId);
    DisciplineDTO registerStudentToDisciplineForCompetition(Long competitionId, Long disciplineId, Long userId);
    List<DisciplineCompetitionDTO> getDisciplinesOfCompetitionForStudent(Long userId);

    List<CompetitionRegisteredStudentsDTO> getCompetitionsDisciplinesWithRegisteredStudents();
    List<CompetitionMedalDTO> getCompetitionMedalsForKarateClub(Long clubId);
}
