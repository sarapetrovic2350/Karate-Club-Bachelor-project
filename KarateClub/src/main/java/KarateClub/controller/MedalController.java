package KarateClub.controller;

import KarateClub.dto.MedalDisciplineDTO;
import KarateClub.model.Group;
import KarateClub.model.Medal;
import KarateClub.service.GroupService;
import KarateClub.service.MedalService;
import KarateClub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/medal", produces = MediaType.APPLICATION_JSON_VALUE)
public class MedalController {

    @Autowired
    private MedalService medalService;

    @Autowired
    public MedalController(MedalService medalService) {
        super();
        this.medalService = medalService;
    }

    @PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR', 'ROLE_STUDENT')")
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<MedalDisciplineDTO>> getAllMedals() {
        return new ResponseEntity<List<MedalDisciplineDTO>>(medalService.getAllMedals(), HttpStatus.OK);
    }
}
