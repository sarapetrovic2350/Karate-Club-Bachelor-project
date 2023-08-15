package KarateClub.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Coach extends User{

    @Column(name = "licenceNumber", unique = true)
    private String licenceNumber;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinTable(name = "coaches_groups",
//            joinColumns = {
//                    @JoinColumn(name = "coachId", referencedColumnName = "userId",
//                            nullable = false, updatable = false)},
//            inverseJoinColumns = {
//                    @JoinColumn(name = "groupId", referencedColumnName = "groupId",
//                            nullable = false, updatable = false)})
//    private Set<Group> groups = new HashSet<>();

    public Coach() {
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

//    public Set<Group> getGroups() {
//        return groups;
//    }
//
//    public void setGroups(Set<Group> groups) {
//        this.groups = groups;
//    }
}
