package KarateClub.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupId", unique = true, nullable = false)
    private Long groupId;

    @Column(name = "groupName", nullable = false)
    private String groupName;

    @Enumerated(EnumType.STRING)
    private GroupCategory groupCategory;

//    @ManyToMany(mappedBy = "groups", fetch = FetchType.LAZY)
//    private Set<Coach> coaches = new HashSet<>();


    public Group(String groupName, GroupCategory groupCategory) {
        super();
        this.groupName = groupName;
        this.groupCategory = groupCategory;
//        this.coaches = coaches;
    }

    public Group() {

    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public GroupCategory getGroupCategory() {
        return groupCategory;
    }

    public void setGroupCategory(GroupCategory groupCategory) {
        this.groupCategory = groupCategory;
    }

//    public Set<Coach> getCoaches() {
//        return coaches;
//    }
//
//    public void setCoaches(Set<Coach> coaches) {
//        this.coaches = coaches;
//    }

}
