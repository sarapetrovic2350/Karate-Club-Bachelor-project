package KarateClub.dto;

import KarateClub.model.Address;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class KarateClubDTO {

    @NotBlank
    private Long clubId;

    @NotBlank
    private String clubName;

    @NotBlank
    private String description;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private Address address;
}
