package KarateClub.controller;

import KarateClub.dto.*;
import KarateClub.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<List<CompetitionDTO>> getAllCompetitions() {
        return new ResponseEntity<List<CompetitionDTO>>(competitionService.getAllCompetitions(), HttpStatus.OK);
    }
    @GetMapping(value = "/getCompetitionsClubIsRegisteredTo/{clubId}")
    public ResponseEntity<List<CompetitionDTO>> getClubIsRegisteredToCompetitions(@PathVariable Long clubId) {
        return new ResponseEntity<List<CompetitionDTO>>(competitionService.getClubIsRegisteredToCompetitions(clubId), HttpStatus.OK);
    }
    @GetMapping(value = "/getDisciplinesForCompetition/{competitionId}")
    public ResponseEntity<List<DisciplineDTO>> getDisciplinesForCompetition(@PathVariable Long competitionId) {
        return new ResponseEntity<List<DisciplineDTO>>(competitionService.getDisciplinesForCompetition(competitionId), HttpStatus.OK);
    }
    @GetMapping(value = "/getDisciplineByCompetitionDisciplineId/{competitionId}/{disciplineId}")
    public ResponseEntity<DisciplineDTO> getDisciplineByCompetitionDisciplineId(@PathVariable Long competitionId, @PathVariable Long disciplineId) {
        return new ResponseEntity<DisciplineDTO>(competitionService.findDisciplineByCompetitionDisciplineId(competitionId, disciplineId), HttpStatus.OK);
    }

    @GetMapping(value = "/getCompetitionById/{competitionId}")
    public CompetitionDTO getCompetitionById(@PathVariable Long competitionId) {
        return new CompetitionDTO(this.competitionService.findById(competitionId));
    }
    @GetMapping(value = "/getDisciplinesOfCompetitionForStudent/{userId}")
    public ResponseEntity<List<DisciplineCompetitionDTO>> getDisciplinesOfCompetitionForStudent(@PathVariable Long userId) {
        return new ResponseEntity<List<DisciplineCompetitionDTO>>(competitionService.getDisciplinesOfCompetitionForStudent(userId), HttpStatus.OK);
    }

    @GetMapping(value = "/getCompetitionMedalsForKarateClub/{clubId}")
    public ResponseEntity<List<CompetitionMedalDTO>> getCompetitionMedalsForKarateClub(@PathVariable Long clubId) {
        return new ResponseEntity<List<CompetitionMedalDTO>>(competitionService.getCompetitionMedalsForKarateClub(clubId), HttpStatus.OK);
    }
    @GetMapping(value = "/getCompetitionsDisciplinesWithRegisteredStudents")
    public ResponseEntity<List<CompetitionRegisteredStudentsDTO>> getCompetitionsDisciplinesWithRegisteredStudents() {
        return new ResponseEntity<List<CompetitionRegisteredStudentsDTO>>(competitionService.getCompetitionsDisciplinesWithRegisteredStudents(), HttpStatus.OK);
    }


    @GetMapping("/findAll")
    public ResponseEntity<Map<String, Object>> findAllWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        try {
            List<CompetitionDTO> competitions;
            Pageable paging = PageRequest.of(page, size);

            List<CompetitionDTO> competitionsDTO = competitionService.getUpcomingCompetitions();
            Page<CompetitionDTO> pageCompetitions = new PageImpl<>(competitionsDTO);
            competitions = pageCompetitions.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("competitions", competitions);
            response.put("currentPage", pageCompetitions.getNumber());
            response.put("totalItems", pageCompetitions.getTotalElements());
            response.put("totalPages", pageCompetitions.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/registerClubToCompetition")
    public ResponseEntity<?> registerClubToCompetition(
            @RequestParam(required = true) Long competitionId,
            @RequestParam(required = true) Long clubId) {
        try {
            this.competitionService.registerClubToCompetition(competitionId, clubId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/checkIfClubIsRegistered")
    public ResponseEntity<Boolean> checkIfClubIsRegistered(
            @RequestParam(required = true) Long competitionId,
            @RequestParam(required = true) Long clubId) {
            boolean isRegistered = this.competitionService.checkIfClubIsRegisteredToCompetition(competitionId, clubId);
            if(isRegistered) {
                return new ResponseEntity<>(true,HttpStatus.OK);
            } else {
                return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
            }
    }

    @PostMapping("/registerStudentToDisciplineForCompetition")
    public ResponseEntity<?> checkIfClubIsRegistered(
            @RequestParam(required = true) Long competitionId,
            @RequestParam(required = true) Long disciplineId,
            @RequestParam(required = true) Long userId) {
            try{
                return new ResponseEntity<>( this.competitionService.registerStudentToDisciplineForCompetition(competitionId, disciplineId, userId),HttpStatus.OK);
            } catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
    }

}
