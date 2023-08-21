package KarateClub.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "competitions")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "competitionId", unique = true, nullable = false)
    private Long competitionId;
    @Column(name = "competitionName", nullable = false)
    private String competitionName;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(name = "place", nullable = false)
    private String place;
    @Column(name = "image")
    private String image;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "competitions_clubs",
            joinColumns = {
                    @JoinColumn(name = "competition_id", referencedColumnName = "competitionId",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "club_id", referencedColumnName = "clubId",
                            nullable = false, updatable = false)})
    private Set<KarateClub> registeredClubs = new HashSet<>();
    @OneToMany(mappedBy="competition")
    private Set<Discipline> disciplines;
    public Competition(String competitionName, String description, LocalDate date, String place, String image) {
        this.competitionName = competitionName;
        this.description = description;
        this.date = date;
        this.place = place;
        this.image = image;
    }


    public Competition() {
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<KarateClub> getRegisteredClubs() {
        return registeredClubs;
    }

    public void setRegisteredClubs(Set<KarateClub> registeredClubs) {
        this.registeredClubs = registeredClubs;
    }

    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }
}
