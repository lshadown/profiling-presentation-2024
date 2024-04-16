package com.gruzewskidev.profiling.player;

import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class PlayerService {
    private  static List<PlayerPoint> playerPoints;

    @SneakyThrows
    public Player findPlayer(UUID playerID){
        Thread.sleep(100);
        return new Player(UUID.randomUUID(), "demo1");
    }

    @SneakyThrows
    public boolean isPlayerActive(UUID playerID){
        Thread.sleep(50);
        return true;
    }

    public List<PlayerPoint> getPoints(UUID playerID){
        return playerPoints;
    }

    @PostConstruct
    public void init(){
        playerPoints = new ArrayList<>();
        Random random = new Random();
        int i = 0;
        while (i < 10_000_000){
            playerPoints.add(new PlayerPoint(random.nextInt()));
            i++;
        }
    }
}
