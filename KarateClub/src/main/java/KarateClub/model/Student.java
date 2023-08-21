package KarateClub.model;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student extends User {

    @Enumerated(EnumType.STRING)
    private BeltColor beltColor;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "groupId", referencedColumnName = "groupId")
    private Group group;
    @JsonIgnore
    @ManyToMany(mappedBy = "registeredStudents", fetch = FetchType.LAZY)
    private Set<Discipline> disciplines = new HashSet<>();

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
