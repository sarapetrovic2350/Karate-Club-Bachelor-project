package KarateClub.service;

import KarateClub.iservice.ICompetitionService;
import KarateClub.model.Competition;
import KarateClub.model.MedicalCenter;
import KarateClub.repository.ICompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService implements ICompetitionService {
    private ICompetitionRepository competitionRepository;

    @Autowired
    public CompetitionService(ICompetitionRepository competitionRepository){
        super();
        this.competitionRepository = competitionRepository;
    }
    @Override
    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    @Override
    public Competition findById(Long id) {
        return competitionRepository.findByCompetitionId(id);
    }

    @Override
    public Page<Competition> findAll(Pageable pageable) {
        return competitionRepository.findAll(pageable);
    }
}
