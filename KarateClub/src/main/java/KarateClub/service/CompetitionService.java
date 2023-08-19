package KarateClub.service;

import KarateClub.dto.CompetitionDTO;
import KarateClub.iservice.ICompetitionService;
import KarateClub.model.Competition;
import KarateClub.model.KarateClub;
import KarateClub.repository.ICompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetitionService implements ICompetitionService {
    private ICompetitionRepository competitionRepository;
    private KarateClubService karateClubService;

    @Autowired
    public CompetitionService(ICompetitionRepository competitionRepository, KarateClubService karateClubService){
        super();
        this.competitionRepository = competitionRepository;
        this.karateClubService = karateClubService;
    }
    @Override
    public List<CompetitionDTO> getAllCompetitions() {
        return competitionRepository.findAll().stream().map(competition -> new CompetitionDTO(competition)).collect(Collectors.toList());
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
        //karateClub.getCompetitions().add(competition);
        competitionRepository.save(competition);
    }

    @Override
    public Page<CompetitionDTO> findAll(Pageable pageable) {
        Page <CompetitionDTO> competitionDTOS = (Page<CompetitionDTO>) competitionRepository.findAll(pageable).stream().map(competition -> new CompetitionDTO(competition)).collect(Collectors.toList());
        return competitionDTOS;
    }
}
