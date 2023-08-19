package KarateClub.dto;

import KarateClub.model.Competition;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class CompetitionDTO {
    @NotBlank
    private Long competitionId;

    @NotBlank
    private String competitionName;

    @NotBlank
    private String description;

    @NotBlank
    private LocalDate date;

    @NotBlank
    private String place;

    @NotBlank
    private String image;

    public CompetitionDTO(Competition competition) {
        this.competitionId = competition.getCompetitionId();
        this.competitionName = competition.getCompetitionName();
        this.description = competition.getDescription();
        this.date = competition.getDate();
        this.place = competition.getPlace();
        this.image = competition.getImage();
    }

}
