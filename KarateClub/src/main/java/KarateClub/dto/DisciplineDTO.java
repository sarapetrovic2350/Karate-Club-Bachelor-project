package KarateClub.dto;

import KarateClub.model.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class DisciplineDTO {
    @NotBlank
    private Long disciplineId;

    @NotBlank
    private DisciplineType disciplineType;

    @NotBlank
    private GroupCategory groupCategory;

    @NotBlank
    private Gender genderCategory;

    private String weightCategory;
    public DisciplineDTO(Discipline discipline) {
        this.disciplineId = discipline.getDisciplineId();
        this.disciplineType = discipline.getDisciplineType();
        this.genderCategory = discipline.getGenderCategory();
        this.groupCategory = discipline.getGroupCategory();
        this.weightCategory = discipline.getWeightCategory();
    }
}
