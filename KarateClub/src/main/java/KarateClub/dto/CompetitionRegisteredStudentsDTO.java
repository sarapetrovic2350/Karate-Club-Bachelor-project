package KarateClub.dto;

import KarateClub.model.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
public class CompetitionRegisteredStudentsDTO {
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
    @NotBlank
    private List<StudentGroupDTO> registeredStudents;

    public CompetitionRegisteredStudentsDTO(Competition competition, Discipline discipline, List<StudentGroupDTO> studentGroupDTOs) {
        this.competitionId = competition.getCompetitionId();
        this.competitionName = competition.getCompetitionName();
        this.date = competition.getDate();
        this.disciplineId = discipline.getDisciplineId();
        this.disciplineType = discipline.getDisciplineType();
        this.genderCategory = discipline.getGenderCategory();
        this.groupCategory = discipline.getGroupCategory();
        this.weightCategory = discipline.getWeightCategory();
        this.registeredStudents = studentGroupDTOs;
    }
}
