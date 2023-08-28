package KarateClub.repository;

import KarateClub.model.MembershipFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMembershipFeeRepository extends JpaRepository<MembershipFee, Long> {
    MembershipFee findMembershipFeeByStudent_UserId(Long userId);
}
