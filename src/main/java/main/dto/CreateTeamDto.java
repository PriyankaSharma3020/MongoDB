package main.dto;
import lombok.Getter;
import lombok.Setter;
import main.models.Address;
import main.models.Team;

@Setter
@Getter
public class CreateTeamDto {
    private String name;

    private String acronym;

    private Address address;

    public Team toTeam() {
        return new Team().setName(name).setAcronym(acronym).setAddress(address);
    }
}
