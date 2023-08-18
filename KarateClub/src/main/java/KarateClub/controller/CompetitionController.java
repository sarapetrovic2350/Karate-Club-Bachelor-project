package KarateClub.controller;

import KarateClub.model.Competition;
import KarateClub.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/competition", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @Autowired
    public CompetitionController(CompetitionService competitionService) {
        super();
        this.competitionService = competitionService;
    }
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Competition>> getAllCompetitions() {
        return new ResponseEntity<List<Competition>>(competitionService.getAllCompetitions(), HttpStatus.OK);
    }

}
