package com.soccer.players.controller;

import com.soccer.players.VO.ResponseTemplateVO;
import com.soccer.players.entities.Player;
import com.soccer.players.services.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@Slf4j
@EnableFeignClients
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/")
    public Player saveTeam(@RequestBody Player player)
    {
        log.info("saving info");
        player = playerService.savePlayer(player);
        playerService.addPlayerToToTeam(player);
        return playerService.savePlayer(player);
    }

    @GetMapping("/getAllPlayers/")
    public List<Player> getAllPlayers()
    {
        return playerService.listAllPlayers();
    }
   @GetMapping("/{playerID}")
    public ResponseTemplateVO findTeam(@PathVariable("playerID") int teamID)
    {
      return playerService.getPlayerAndTeamById(teamID);
    }

    @DeleteMapping("/{playerID}")
    public List<Player> deleteAPlayer(@PathVariable("playerID") int playerID)
    {
        playerService.deletePlayer(playerID);
        return playerService.listAllPlayers();
    }
    @PutMapping("/editPlayer/")
    public Player findTeam(@RequestBody Player player)
    {
        if(playerService.getPlayerById(player.getId())!=null)
        {
            player = playerService.savePlayer(player);
        }
        return player;
    }


}
