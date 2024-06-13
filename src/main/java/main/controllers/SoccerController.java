package main.controllers;

import main.Repository.PlayerRepository;
import main.Repository.TeamRepository;
import main.dto.CreatePlayerDto;
import main.dto.CreateTeamDto;
import main.models.Player;
import main.models.Team;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SoccerController {

    TeamRepository teamRepository;

    PlayerRepository playerRepository;

    public SoccerController(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }
    @PostMapping("/teams")
    public ResponseEntity<Team> createTeam(@RequestBody CreateTeamDto createTeamDto) {
        Team teamCreated = teamRepository.save(createTeamDto.toTeam());

        return new ResponseEntity<>(teamCreated, HttpStatus.CREATED);
    }

    @GetMapping("/teams/{city}")
    public ResponseEntity<List<Team>> getTeamByCity(@PathVariable String city)
    {
        List<Team> teamsOfCity = teamRepository.findByAddressCityIgnoreCase(city);
        return new ResponseEntity<>(teamsOfCity,HttpStatus.OK);
    }

    @PostMapping("/players")
    public ResponseEntity<Player> createPlayer(@RequestBody CreatePlayerDto createPlayerDto) {
        Player playerCreated = playerRepository.save(createPlayerDto.toPlayer());
        return new ResponseEntity<>(playerCreated, HttpStatus.CREATED);
    }

}
