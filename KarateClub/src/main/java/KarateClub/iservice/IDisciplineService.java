package KarateClub.iservice;

import KarateClub.model.Discipline;
import org.springframework.stereotype.Service;

@Service
public interface IDisciplineService {

    Discipline save(Discipline discipline);
}
