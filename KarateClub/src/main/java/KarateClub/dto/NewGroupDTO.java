package KarateClub.dto;

import KarateClub.model.GroupCategory;
import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class NewGroupDTO {
    @NotBlank
    private String groupName;

    @NotBlank
    private GroupCategory groupCategory;

    private Long coachId;
}
