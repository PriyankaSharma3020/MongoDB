package main.dto;


import java.util.Date;
        import lombok.Getter;
        import lombok.Setter;
import main.models.Player;
import main.models.PlayerPosition;

@Setter
@Getter
public class CreatePlayerDto {
    private String name;

    private Date birthDate;

    private PlayerPosition position;

    private boolean isAvailable;

    public Player toPlayer() {
        return new Player().setName(name).setBirthDate(birthDate).setPosition(position).setAvailable(isAvailable);
    }
}
