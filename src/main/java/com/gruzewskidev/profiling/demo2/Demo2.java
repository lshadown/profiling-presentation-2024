package com.gruzewskidev.profiling.demo2;

import com.gruzewskidev.profiling.player.Player;
import com.gruzewskidev.profiling.player.PlayerPoint;
import com.gruzewskidev.profiling.player.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class Demo2 {
    private final PlayerService playerService;

    public Demo2(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Integer getSumOfPlayerPoints(UUID playerID){
        Player player = playerService.findPlayer(playerID);
        if(playerService.isPlayerActive(playerID)) {
            List<PlayerPoint> playerPoints = playerService.getPoints(playerID);
            return sum2(playerPoints);
        }
        return 0;
    }

    public Integer sum2(List<PlayerPoint> playerPoints){
        int sum = 0;
        log.debug("Points: {}" + playerPoints);
        for (int i = 0; i < playerPoints.size(); i++) {
            PlayerPoint point = playerPoints.get(i);
            sum += point.getPoint();
        }
        return sum;
    }
}
