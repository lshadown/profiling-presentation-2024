package com.gruzewskidev.profiling.demo1;

import com.gruzewskidev.profiling.player.Player;
import com.gruzewskidev.profiling.player.PlayerPoint;
import com.gruzewskidev.profiling.player.PlayerService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class Demo1 {
    private final PlayerService playerService;

    public Demo1(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Integer getSumOfPlayerPoints(UUID playerID){
        Player player = playerService.findPlayer(playerID);
        if(playerService.isPlayerActive(playerID)) {
            List<PlayerPoint> playerPoints = playerService.getPoints(playerID);
            return sum(playerPoints);
        }
        return 0;
    }

    public Integer sum(List<PlayerPoint> playerPoints){
        return playerPoints
                .stream()
                .mapToInt(p -> p.getPoint())
                .sum();
    }
}
