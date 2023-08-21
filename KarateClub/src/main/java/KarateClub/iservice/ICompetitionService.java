package KarateClub.iservice;

import KarateClub.dto.CompetitionDTO;
import KarateClub.model.Competition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICompetitionService {
    List<CompetitionDTO> getAllCompetitions();
    List<CompetitionDTO> getClubIsRegisteredToCompetitions(Long clubId);
    //Page<CompetitionDTO> findAll(Pageable pageable);

    Competition findById(Long id);
    void registerClubToCompetition(Long competitionId, Long clubId);
    Boolean checkIfClubIsRegisteredToCompetition(Long competitionId, Long clubId);
}
