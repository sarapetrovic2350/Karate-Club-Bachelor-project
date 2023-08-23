package KarateClub.dto;

import KarateClub.model.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Data
public class CompetitionMedalDTO {
    @NotBlank
    private String competitionName;
    @NotBlank
    private LocalDate date;
    @NotBlank
    private MedalType medalType;
    @NotBlank
    private DisciplineType disciplineType;
    @NotBlank
    private GroupCategory groupCategory;
    @NotBlank
    private Gender genderCategory;
    private String weightCategory;
    @NotBlank
    private String awardedStudentName;
    @NotBlank
    private String awardedStudentSurname;
    public CompetitionMedalDTO(Competition competition, MedalDisciplineDTO medalDisciplineDTO) {
        this.competitionName = competition.getCompetitionName();
        this.date = competition.getDate();
        this.disciplineType = medalDisciplineDTO.getDisciplineType();
        this.genderCategory = medalDisciplineDTO.getGenderCategory();
        this.groupCategory = medalDisciplineDTO.getGroupCategory();
        this.weightCategory = medalDisciplineDTO.getWeightCategory();
        this.medalType = medalDisciplineDTO.getMedalType();
        this.awardedStudentName = medalDisciplineDTO.getAwardedStudentName();
        this.awardedStudentSurname = medalDisciplineDTO.getAwardedStudentSurname();
    }
}
