package KarateClub.model;

import javax.persistence.*;

@Entity
public class Student extends User {

    @Enumerated(EnumType.STRING)
    private BeltColor beltColor;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "groupId", referencedColumnName = "groupId")
    private Group group;

    public BeltColor getBeltColor() {
        return beltColor;
    }

    public void setBeltColor(BeltColor beltColor) {
        this.beltColor = beltColor;
    }
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
