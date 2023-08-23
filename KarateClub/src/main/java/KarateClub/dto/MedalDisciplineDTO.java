package KarateClub.dto;

import KarateClub.model.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MedalDisciplineDTO {

    @NotBlank
    private Long medalId;

    @NotBlank
    private MedalType medalType;

    @NotBlank
    private String medalName;

    @NotBlank
    private Long disciplineId;

    @NotBlank
    private DisciplineType disciplineType;

    @NotBlank
    private GroupCategory groupCategory;

    @NotBlank
    private Gender genderCategory;

    private String weightCategory;

    @NotBlank
    private Long userId;

    @NotBlank
    private String awardedStudentName;
    @NotBlank
    private String awardedStudentSurname;
    @NotBlank
    private String studentClubName;
    @NotBlank
    private Long studentClubId;
    public MedalDisciplineDTO(Medal medal, Discipline discipline, Student student) {
        this.medalId = medal.getMedalId();
        this.medalType = medal.getMedalType();
        this.medalName = medal.getMedalName();
        this.disciplineId = discipline.getDisciplineId();
        this.disciplineType = discipline.getDisciplineType();
        this.genderCategory = discipline.getGenderCategory();
        this.groupCategory = discipline.getGroupCategory();
        this.weightCategory = discipline.getWeightCategory();
        this.userId = student.getUserId();
        this.awardedStudentName = student.getName();
        this.awardedStudentSurname = student.getSurname();
        this.studentClubName = student.getKarateClub().getName();
        this.studentClubId = student.getKarateClub().getClubId();
    }
}
