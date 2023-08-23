package KarateClub.service;

import KarateClub.dto.DisciplineDTO;
import KarateClub.iservice.IDisciplineService;
import KarateClub.iservice.IUserService;
import KarateClub.model.Discipline;
import KarateClub.model.Student;
import KarateClub.model.User;
import KarateClub.repository.IDisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DisciplineService implements IDisciplineService {
    private IDisciplineRepository disciplineRepository;
    private UserService userService;

    @Autowired
    public DisciplineService(IDisciplineRepository disciplineRepository, UserService userService) {
        this.disciplineRepository = disciplineRepository;
        this.userService = userService;
    }
    @Override
    public Discipline save(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    @Override
    public List<DisciplineDTO> getDisciplinesStudentIsRegisteredTo(Long userId) {
        List<Discipline> allDisciplines = disciplineRepository.findAll();
        List<Discipline> disciplinesForUser = new ArrayList<>();
        User user = userService.findById(userId);
        for(Discipline discipline: allDisciplines) {
            for(Student student: discipline.getRegisteredStudents()) {
                if (student == user) {
                    disciplinesForUser.add(discipline);
                }
            }
        }
        return disciplinesForUser.stream().map(discipline -> new DisciplineDTO(discipline)).collect(Collectors.toList());
    }
}
