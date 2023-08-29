package KarateClub.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "membership_fees")
public class MembershipFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "membershipFeeId", unique = true, nullable = false)
    private Long membershipFeeId;
    @Column(name = "membershipFeeName", nullable = false)
    private String membershipFeeName;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "paymentDate")
    private LocalDate paymentDate;
    @Column(name="isPaidForMonth", nullable = false)
    private boolean isPaidForMonth;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "studentId", referencedColumnName = "userId")
    private Student student;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "clubId", referencedColumnName = "clubId")
    private KarateClub karateClub;

    public MembershipFee(String membershipFeeName, double price, LocalDate paymentDate, boolean isPaidForMonth, Student student, KarateClub karateClub) {
        this.membershipFeeName = membershipFeeName;
        this.price = price;
        this.paymentDate = paymentDate;
        this.isPaidForMonth = isPaidForMonth;
        this.student = student;
        this.karateClub = karateClub;
    }

    public MembershipFee() {
    }

    public Long getMembershipFeeId() {
        return membershipFeeId;
    }

    public void setMembershipFeeId(Long membershipFeeId) {
        this.membershipFeeId = membershipFeeId;
    }

    public String getMembershipFeeName() {
        return membershipFeeName;
    }

    public void setMembershipFeeName(String membershipFeeName) {
        this.membershipFeeName = membershipFeeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean isPaidForMonth() {
        return isPaidForMonth;
    }

    public void setPaidForMonth(boolean paidForMonth) {
        isPaidForMonth = paidForMonth;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public KarateClub getKarateClub() {
        return karateClub;
    }

    public void setKarateClub(KarateClub karateClub) {
        this.karateClub = karateClub;
    }
}
