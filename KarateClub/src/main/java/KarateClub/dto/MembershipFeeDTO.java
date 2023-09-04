package KarateClub.dto;

import KarateClub.model.MembershipFee;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class MembershipFeeDTO {
    @NotBlank
    private Long membershipFeeId;

    @NotBlank
    private String membershipFeeName;

    private LocalDate paymentDate;

    @NotBlank
    private String isPaidForMonth;

    @NotBlank
    private double price;

    @NotBlank
    private Long studentId;

    @NotBlank
    private Long clubId;

    public MembershipFeeDTO(MembershipFee membershipFee) {
        this.membershipFeeId = membershipFee.getMembershipFeeId();
        this.membershipFeeName = membershipFee.getMembershipFeeName();
        if(membershipFee.getPaymentDate() != null) {
            this.paymentDate = membershipFee.getPaymentDate();
        }
        this.price = membershipFee.getPrice();
        this.studentId = membershipFee.getStudent().getUserId();
        this.clubId = membershipFee.getKarateClub().getClubId();
        if(membershipFee.isPaidForMonth()) {
            this.isPaidForMonth = "Yes";
        }
        else {
            this.isPaidForMonth = "No";
        }
    }
}
