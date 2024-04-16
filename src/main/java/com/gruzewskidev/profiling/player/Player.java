package com.gruzewskidev.profiling.player;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Player {
    private UUID id;
    private String nick;
}
