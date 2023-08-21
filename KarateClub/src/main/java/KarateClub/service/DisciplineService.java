package KarateClub.service;

import KarateClub.iservice.IDisciplineService;
import KarateClub.model.Discipline;
import KarateClub.repository.IDisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplineService implements IDisciplineService {
    private IDisciplineRepository disciplineRepository;

    @Autowired
    public DisciplineService(IDisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }
    @Override
    public Discipline save(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }
}
