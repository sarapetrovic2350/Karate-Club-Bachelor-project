package KarateClub.model;

import javax.persistence.*;

@Entity
@Table(name = "karate_clubs")
public class KarateClub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clubId", unique = true, nullable = false)
    private Long clubId;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    private Address address;

    public KarateClub(String name, String phoneNumber, Address address) {
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public KarateClub() {

    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
