package KarateClub.service;

import KarateClub.dto.MedalDisciplineDTO;
import KarateClub.iservice.IMedalService;
import KarateClub.model.DisciplineType;
import KarateClub.model.Medal;
import KarateClub.repository.IMedalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedalService implements IMedalService {
    private IMedalRepository medalRepository;

    @Autowired
    public MedalService(IMedalRepository medalRepository) {
        super();
        this.medalRepository = medalRepository;
    }

    @Override
    public List<MedalDisciplineDTO> getAllMedals() {
        List<Medal> medals =  medalRepository.findAll();
        List<MedalDisciplineDTO> medalDisciplineDTOS = new ArrayList<>();
        for(Medal medal: medals) {
            MedalDisciplineDTO medalDisciplineDTO = new MedalDisciplineDTO(medal, medal.getDiscipline(), medal.getAwardedStudent());
            medalDisciplineDTOS.add(medalDisciplineDTO);
        }
        return medalDisciplineDTOS;
    }
}
