package KarateClub.controller;

import KarateClub.dto.*;
import KarateClub.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

@RestController
@RequestMapping(value = "/competition", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompetitionController {

    private CompetitionService competitionService;

    @Autowired
    public CompetitionController(CompetitionService competitionService) {
        super();
        this.competitionService = competitionService;
    }

    @PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR')")
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<CompetitionDTO>> getAllCompetitions() {
        return new ResponseEntity<List<CompetitionDTO>>(competitionService.getAllCompetitions(), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR', 'ROLE_STUDENT')")
    @GetMapping(value = "/getCompetitionsClubIsRegisteredTo/{clubId}")
    public ResponseEntity<List<CompetitionDTO>> getClubIsRegisteredToCompetitions(@PathVariable Long clubId) {
        return new ResponseEntity<List<CompetitionDTO>>(competitionService.getClubIsRegisteredToCompetitions(clubId), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR')")
    @GetMapping(value = "/getDisciplinesForCompetition/{competitionId}")
    public ResponseEntity<List<DisciplineDTO>> getDisciplinesForCompetition(@PathVariable Long competitionId) {
        return new ResponseEntity<List<DisciplineDTO>>(competitionService.getDisciplinesForCompetition(competitionId), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR')")
    @GetMapping(value = "/getDisciplineByCompetitionDisciplineId/{competitionId}/{disciplineId}")
    public ResponseEntity<DisciplineDTO> getDisciplineByCompetitionDisciplineId(@PathVariable Long competitionId, @PathVariable Long disciplineId) {
        return new ResponseEntity<DisciplineDTO>(competitionService.findDisciplineByCompetitionDisciplineId(competitionId, disciplineId), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR')")
    @GetMapping(value = "/getCompetitionById/{competitionId}")
    public CompetitionDTO getCompetitionById(@PathVariable Long competitionId) {
        return new CompetitionDTO(this.competitionService.findById(competitionId));
    }

    @PreAuthorize("hasRole('ROLE_STUDENT')")
    @GetMapping(value = "/getDisciplinesOfCompetitionForStudent/{userId}")
    public ResponseEntity<List<DisciplineCompetitionDTO>> getDisciplinesOfCompetitionForStudent(@PathVariable Long userId) {
        return new ResponseEntity<List<DisciplineCompetitionDTO>>(competitionService.getDisciplinesOfCompetitionForStudent(userId), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR', 'ROLE_STUDENT')")
    @GetMapping(value = "/getCompetitionMedalsForKarateClub/{clubId}")
    public ResponseEntity<List<CompetitionMedalDTO>> getCompetitionMedalsForKarateClub(@PathVariable Long clubId) {
        return new ResponseEntity<List<CompetitionMedalDTO>>(competitionService.getCompetitionMedalsForKarateClub(clubId), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR')")
    @GetMapping(value = "/getCompetitionsDisciplinesWithRegisteredStudents/{clubId}")
    public ResponseEntity<List<CompetitionRegisteredStudentsDTO>> getCompetitionsDisciplinesWithRegisteredStudents(@PathVariable Long clubId) {
        return new ResponseEntity<List<CompetitionRegisteredStudentsDTO>>(competitionService.getCompetitionsDisciplinesWithRegisteredStudents(clubId), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR', 'ROLE_STUDENT')")
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

    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    @PostMapping("/registerClubToCompetition")
    public ResponseEntity<?> registerClubToCompetition(
            @RequestParam(required = true) Long competitionId,
            @RequestParam(required = true) Long clubId,
            @RequestParam(required = true) Long administratorId)
    {
        try {
            this.competitionService.registerClubToCompetition(competitionId, clubId, administratorId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_COACH', 'ROLE_ADMINISTRATOR')")
    @RequestMapping(value = "/checkIfClubIsRegistered", method = RequestMethod.GET)
    public ResponseEntity<Boolean> checkIfClubIsRegistered(
            @RequestParam(required = true) Long competitionId,
            @RequestParam(required = true) Long clubId) {
            return new ResponseEntity<>(this.competitionService.checkIfClubIsRegisteredToCompetition(competitionId, clubId), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_COACH')")
    @PostMapping(value = "/registerStudentToDisciplineForCompetition")
    public ResponseEntity<?> registerStudentToDisciplineForCompetition(
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
