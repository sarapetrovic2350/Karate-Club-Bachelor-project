package KarateClub.model;

import javax.persistence.*;

@Entity
@Table(name = "medals")
public class Medal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medalId", unique = true, nullable = false)
    private Long medalId;

    @Column(name = "medalName", nullable = false)
    private String medalName;
    @Enumerated(EnumType.STRING)
    private MedalType medalType;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "studentId", referencedColumnName = "userId")
    private Student awardedStudent;

    @ManyToOne
    @JoinColumn(name="discipline_id", nullable=false)
    private Discipline discipline;

    public Medal() {
    }

    public Long getMedalId() {
        return medalId;
    }

    public void setMedalId(Long medalId) {
        this.medalId = medalId;
    }

    public String getMedalName() {
        return medalName;
    }

    public void setMedalName(String medalName) {
        this.medalName = medalName;
    }

    public MedalType getMedalType() {
        return medalType;
    }

    public void setMedalType(MedalType medalType) {
        this.medalType = medalType;
    }

    public Student getAwardedStudent() {
        return awardedStudent;
    }

    public void setAwardedStudent(Student awardedStudent) {
        this.awardedStudent = awardedStudent;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
}
