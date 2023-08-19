package KarateClub.service;

import KarateClub.iservice.IKarateClubService;
import KarateClub.model.KarateClub;
import KarateClub.repository.IKarateClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KarateClubService implements IKarateClubService {
    private IKarateClubRepository karateClubRepository;

    @Autowired
    public KarateClubService(IKarateClubRepository karateClubRepository) {
        super();
        this.karateClubRepository = karateClubRepository;
    }

    @Override
    public KarateClub findById(Long id) {
        return this.karateClubRepository.findByClubId(id);
    }
}
