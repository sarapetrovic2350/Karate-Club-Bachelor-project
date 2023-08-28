package KarateClub.iservice;

import KarateClub.model.MembershipFee;
import KarateClub.model.Student;
import org.springframework.stereotype.Service;

@Service
public interface IMembershipFeeService {
    MembershipFee createMembershipFeeForStudent(Student student);
    MembershipFee payMembership(Long studentId);
    boolean checkIfMembershipIsPaidForMonth(Long studentId);
}
