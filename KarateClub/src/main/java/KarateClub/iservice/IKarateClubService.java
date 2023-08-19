package KarateClub.iservice;

import KarateClub.model.KarateClub;
import org.springframework.stereotype.Service;

@Service
public interface IKarateClubService {
    KarateClub findById(Long id);
}
