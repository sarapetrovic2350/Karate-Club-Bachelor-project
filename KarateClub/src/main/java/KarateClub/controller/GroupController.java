package KarateClub.controller;

import KarateClub.dto.NewGroupDTO;
import KarateClub.model.Coach;
import KarateClub.model.Group;
import KarateClub.service.GroupService;
import KarateClub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/group", produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController {
    private GroupService groupService;
    private UserService userService;

    @Autowired
    public GroupController(GroupService groupService, UserService userService) {
        super();
        this.groupService = groupService;
        this.userService = userService;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR','ROLE_COACH')")
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Group>> getAllGroups() {
        return new ResponseEntity<List<Group>>(groupService.getAllGroups(), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR','ROLE_COACH')")
    @GetMapping(value = "/getAllClubGroups/{clubId}")
    public ResponseEntity<List<Group>> getAllClubGroups(@PathVariable Long clubId) {
        return new ResponseEntity<List<Group>>(groupService.getAllClubGroups(clubId), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR','ROLE_COACH')")
    @GetMapping(value = "/getAllGroupsWithoutCoach")
    public ResponseEntity<List<Group>> getAllGroupsWithoutCoach() {
        return new ResponseEntity<List<Group>>(groupService.getAllGroupsWithoutCoach(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    @PostMapping(value = "/createGroup")
    public ResponseEntity<?> createGroup(@RequestBody NewGroupDTO newGroupDTO,
                                          UriComponentsBuilder uriComponentsBuilder) {
        try {
            if(!(newGroupDTO.getCoachId() == null)) {
                Coach coach = (Coach) userService.findById(newGroupDTO.getCoachId());
                return new ResponseEntity<>(groupService.createGroup(newGroupDTO, coach), HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>(groupService.createGroupWithoutCoach(newGroupDTO), HttpStatus.CREATED);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
