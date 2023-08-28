package KarateClub.service;

import KarateClub.dto.MembershipFeeDTO;
import KarateClub.iservice.IMembershipFeeService;
import KarateClub.model.MembershipFee;
import KarateClub.model.Student;
import KarateClub.repository.IMembershipFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class MembershipFeeService implements IMembershipFeeService {
    private IMembershipFeeRepository membershipFeeRepository;

    @Autowired
    public MembershipFeeService(IMembershipFeeRepository membershipFeeRepository) {
        this.membershipFeeRepository = membershipFeeRepository;
    }
    @Override
    public MembershipFee createMembershipFeeForStudent(Student student) {
        MembershipFee membershipFee = new MembershipFee();
        membershipFee.setStudent(student);
        membershipFee.setPaidForMonth(false);
        membershipFee.setKarateClub(student.getKarateClub());
        List<MembershipFee> allFees = membershipFeeRepository.findAll();
        for (MembershipFee membershipFeeClub: allFees) {
            if(Objects.equals(membershipFeeClub.getKarateClub().getClubId(), student.getKarateClub().getClubId())){
                membershipFee.setMembershipFeeName(membershipFeeClub.getMembershipFeeName());
                membershipFee.setPrice(membershipFeeClub.getPrice());
                break;
            }
        }
        return membershipFeeRepository.save(membershipFee);
    }

    @Override
    public MembershipFeeDTO payMembership(Long studentId) {
        MembershipFee membershipFee = membershipFeeRepository.findMembershipFeeByStudent_UserId(studentId);
        membershipFee.setPaymentDate(LocalDate.now());
        membershipFee.setPaidForMonth(true);
        membershipFeeRepository.save(membershipFee);
        return new MembershipFeeDTO(membershipFee);
    }

    @Override
    public boolean checkIfMembershipIsPaidForMonth(Long studentId) {
        MembershipFee membershipFee = membershipFeeRepository.findMembershipFeeByStudent_UserId(studentId);
        if(membershipFee.getPaymentDate() == null)
            return false;

        LocalDate validDate = membershipFee.getPaymentDate().plusMonths(1);
        if(membershipFee.isPaidForMonth() && LocalDate.now().isBefore(validDate))
            return true;

        membershipFee.setPaidForMonth(false);
        membershipFeeRepository.save(membershipFee);
        return false;
    }

    @Override
    public MembershipFeeDTO getMembershipFee(Long studentId) {
        MembershipFee membershipFee = membershipFeeRepository.findMembershipFeeByStudent_UserId(studentId);
        return new MembershipFeeDTO(membershipFee);
    }
}
