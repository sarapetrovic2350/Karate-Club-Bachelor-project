package KarateClub.dto;

import KarateClub.model.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class DisciplineCompetitionDTO {

    @NotBlank
    private Long competitionId;

    @NotBlank
    private String competitionName;

    @NotBlank
    private LocalDate date;

    @NotBlank
    private Long disciplineId;

    @NotBlank
    private DisciplineType disciplineType;

    @NotBlank
    private GroupCategory groupCategory;

    @NotBlank
    private Gender genderCategory;

    private String weightCategory;

    public DisciplineCompetitionDTO(Competition competition, Discipline discipline) {
        this.competitionId = competition.getCompetitionId();
        this.competitionName = competition.getCompetitionName();
        this.date = competition.getDate();
        this.disciplineId = discipline.getDisciplineId();
        this.disciplineType = discipline.getDisciplineType();
        this.genderCategory = discipline.getGenderCategory();
        this.groupCategory = discipline.getGroupCategory();
        this.weightCategory = discipline.getWeightCategory();
    }

}
