package com.soccer.players.client;

import com.soccer.players.VO.Team;
import com.soccer.players.configuration.FeignClientConfig;
import com.soccer.players.entities.Player;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "TEAM-CLIENT",url="${team.service.url}",configuration = FeignClientConfig.class)

public interface TeamFeignClient {

    @GetMapping(value="/teams/{teamID}",consumes = MediaType.APPLICATION_JSON_VALUE)
    Team getTeam(@PathVariable(value="teamID") String id);

    @GetMapping(value="/teams/",consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Team> getTeams();

    @PutMapping(value="/teams/addPlayerToTeam/",consumes = MediaType.APPLICATION_JSON_VALUE)
    boolean addPlayerToTeam(@RequestBody Player player);
}
