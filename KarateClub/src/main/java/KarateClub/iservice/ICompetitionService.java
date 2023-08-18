package KarateClub.iservice;

import KarateClub.model.Competition;
import KarateClub.model.Group;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICompetitionService {
    List<Competition> getAllCompetitions();

    Competition findById(Long id);
}
