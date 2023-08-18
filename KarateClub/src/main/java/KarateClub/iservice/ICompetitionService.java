package KarateClub.iservice;

import KarateClub.model.Competition;
import KarateClub.model.Group;
import KarateClub.model.MedicalCenter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICompetitionService {
    List<Competition> getAllCompetitions();
    Page<Competition> findAll(Pageable pageable);

    Competition findById(Long id);
}
