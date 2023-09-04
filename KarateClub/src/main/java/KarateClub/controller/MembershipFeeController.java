package KarateClub.controller;

import KarateClub.dto.MembershipFeeDTO;
import KarateClub.model.MembershipFee;
import KarateClub.service.MembershipFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/membershipFee", produces = MediaType.APPLICATION_JSON_VALUE)
public class MembershipFeeController {
    private MembershipFeeService membershipFeeService;

    @Autowired
    public MembershipFeeController(MembershipFeeService membershipFeeService) {
        this.membershipFeeService = membershipFeeService;
    }

    @PreAuthorize("hasRole('ROLE_STUDENT')")
    @PostMapping(value = "/payMembership/{studentId}")
    public ResponseEntity<MembershipFeeDTO> payMembership(@PathVariable Long studentId) {
        return new ResponseEntity<MembershipFeeDTO>(membershipFeeService.payMembership(studentId), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_STUDENT')")
    @GetMapping(value = "/checkIfMembershipIsPaidForMonth/{studentId}")
    public ResponseEntity<Boolean> checkIfMembershipIsPaidForMonth(@PathVariable Long studentId) {
        return new ResponseEntity<Boolean>(membershipFeeService.checkIfMembershipIsPaidForMonth(studentId), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_STUDENT')")
    @GetMapping(value = "/getMembershipFee/{studentId}")
    public ResponseEntity<MembershipFeeDTO> getMembershipFee(@PathVariable Long studentId) {
        return new ResponseEntity<MembershipFeeDTO>(membershipFeeService.getMembershipFee(studentId), HttpStatus.OK);
    }
}
