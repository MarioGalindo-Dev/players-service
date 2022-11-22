package com.soccer.players.services;



import com.soccer.players.VO.ResponseTemplateVO;
import com.soccer.players.client.TeamFeignClient;
import com.soccer.players.entities.Player;
import com.soccer.players.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Player service implement.
 */
@Service
public class PlayerService {
     @Autowired
     private PlayerRepository playerRepository;
     @Autowired
     private TeamFeignClient teamFeignClient;



    public List<Player> listAllPlayers() {
        return playerRepository.findAll();
    }


    public Player getPlayerById(Integer id) {
        return playerRepository.findById(id).get();
    }


    public ResponseTemplateVO getPlayerAndTeamById(Integer id)
    {
        var player= playerRepository.findById(id).get();
        var team =teamFeignClient.getTeam(String.valueOf(player.getTeamID()));
        var responseTemplate = new ResponseTemplateVO();
        responseTemplate.setPlayer(player);
        responseTemplate.setTeam(team);
        return responseTemplate;
    }

    public Player savePlayer(Player player)
    {
        player = playerRepository.save(player);
        return player;
    }


    public Player addPlayerToToTeam(Player player)
    {
        var t=  teamFeignClient.addPlayerToTeam(player);
        return player;
    }


    public void deletePlayer(Integer id)
    {
        playerRepository.deleteById(id);
    }

}
