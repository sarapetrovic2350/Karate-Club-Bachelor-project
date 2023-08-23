package KarateClub.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "disciplines")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disciplineId", unique = true, nullable = false)
    private Long disciplineId;
    @Enumerated(EnumType.STRING)
    private DisciplineType disciplineType;
    @Enumerated(EnumType.STRING)
    private Gender genderCategory;
    @Enumerated(EnumType.STRING)
    private GroupCategory groupCategory;
    @Column(name = "weightCategory")
    private String weightCategory;
    @ManyToOne
    @JoinColumn(name="competition_id", nullable=false)
    private Competition competition;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "disciplines_users",
            joinColumns = {
                    @JoinColumn(name = "discipline_id", referencedColumnName = "disciplineId",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "student_id", referencedColumnName = "userId",
                            nullable = false, updatable = false)})
    private Set<Student> registeredStudents = new HashSet<>();

    public Discipline() {
    }

    public Long getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Long disciplineId) {
        this.disciplineId = disciplineId;
    }

    public DisciplineType getDisciplineType() {
        return disciplineType;
    }

    public void setDisciplineType(DisciplineType disciplineType) {
        this.disciplineType = disciplineType;
    }

    public Gender getGenderCategory() {
        return genderCategory;
    }

    public void setGenderCategory(Gender genderCategory) {
        this.genderCategory = genderCategory;
    }

    public GroupCategory getGroupCategory() {
        return groupCategory;
    }

    public void setGroupCategory(GroupCategory groupCategory) {
        this.groupCategory = groupCategory;
    }

    public String getWeightCategory() {
        return weightCategory;
    }

    public void setWeightCategory(String weightCategory) {
        this.weightCategory = weightCategory;
    }

    public Set<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(Set<Student> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

}
