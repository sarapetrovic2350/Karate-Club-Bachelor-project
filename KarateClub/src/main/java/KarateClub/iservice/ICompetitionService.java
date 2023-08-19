package KarateClub.iservice;

import KarateClub.dto.CompetitionDTO;
import KarateClub.model.Competition;
import KarateClub.model.Group;
import KarateClub.model.MedicalCenter;
import KarateClub.service.CompetitionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICompetitionService {
    List<CompetitionDTO> getAllCompetitions();
    Page<CompetitionDTO> findAll(Pageable pageable);

    Competition findById(Long id);
    void registerClubToCompetition(Long competitionId, Long clubId);
}
