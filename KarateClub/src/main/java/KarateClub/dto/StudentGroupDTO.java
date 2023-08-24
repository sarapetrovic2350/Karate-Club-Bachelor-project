package KarateClub.dto;

import KarateClub.model.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StudentGroupDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String groupName;

    @NotBlank
    private String coachName;

    @NotBlank
    private String coachSurname;

    public StudentGroupDTO(Student student, Group group, Coach coach) {
        this.name = student.getName();
        this.surname = student.getSurname();
        this.groupName = student.getGroup().getGroupName();
        this.coachName = student.getGroup().getCoach().getName();
        this.coachSurname = student.getGroup().getCoach().getSurname();
    }

}
