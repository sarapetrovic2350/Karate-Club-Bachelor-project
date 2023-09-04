package KarateClub.iservice;

import KarateClub.dto.MembershipFeeDTO;
import KarateClub.model.MembershipFee;
import KarateClub.model.Student;
import org.springframework.stereotype.Service;

@Service
public interface IMembershipFeeService {
    MembershipFee createMembershipFeeForStudent(Student student);
    MembershipFeeDTO payMembership(Long studentId);
    boolean checkIfMembershipIsPaidForMonth(Long studentId);

    MembershipFeeDTO getMembershipFee(Long studentId);
}
