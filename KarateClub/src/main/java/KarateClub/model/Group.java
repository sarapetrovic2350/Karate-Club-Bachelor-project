package KarateClub.model;

import javax.persistence.*;

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

        @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JoinColumn(name = "coachId", referencedColumnName = "userId")
        private Coach coach;


    public Group(String groupName, GroupCategory groupCategory) {
        super();
        this.groupName = groupName;
        this.groupCategory = groupCategory;
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

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
