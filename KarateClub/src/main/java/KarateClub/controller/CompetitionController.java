package KarateClub.controller;

import KarateClub.dto.CompetitionDTO;
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
    @GetMapping("/findAll")
    public ResponseEntity<Map<String, Object>> findAllWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        try {
            List<CompetitionDTO> competitions;
            Pageable paging = PageRequest.of(page, size);

            List<CompetitionDTO> competitionsDTO = competitionService.getAllCompetitions();
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

}
