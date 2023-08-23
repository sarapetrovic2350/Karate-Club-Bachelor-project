package KarateClub.iservice;

import KarateClub.dto.MedalDisciplineDTO;
import KarateClub.model.Medal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMedalService {
    List<MedalDisciplineDTO> getAllMedals();
}
