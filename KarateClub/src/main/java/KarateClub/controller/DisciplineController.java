package KarateClub.controller;

import KarateClub.dto.CompetitionDTO;
import KarateClub.dto.DisciplineDTO;
import KarateClub.model.Discipline;
import KarateClub.service.CompetitionService;
import KarateClub.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/discipline", produces = MediaType.APPLICATION_JSON_VALUE)
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;
    @Autowired
    public DisciplineController(DisciplineService disciplineService) {
        super();
        this.disciplineService = disciplineService;
    }

    @GetMapping(value = "/getDisciplinesStudentIsRegisteredTo/{userId}")
    public ResponseEntity<List<DisciplineDTO>> getDisciplinesStudentIsRegisteredTo(@PathVariable Long userId) {
        return new ResponseEntity<List<DisciplineDTO>>(disciplineService.getDisciplinesStudentIsRegisteredTo(userId), HttpStatus.OK);
    }
}
