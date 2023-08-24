package KarateClub.iservice;

import KarateClub.dto.DisciplineDTO;
import KarateClub.model.Discipline;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDisciplineService {

    Discipline save(Discipline discipline);
    List<Discipline> findAll();
    List<Discipline> getDisciplinesWhichHaveRegisteredUsers();
    List<DisciplineDTO> getDisciplinesStudentIsRegisteredTo(Long userId);
}
