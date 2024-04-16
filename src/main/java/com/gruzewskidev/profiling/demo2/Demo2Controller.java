package com.gruzewskidev.profiling.demo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/demo2")
public class Demo2Controller {
    private Demo2 demo2;

    public Demo2Controller(Demo2 demo2) {
        this.demo2 = demo2;
    }

    @GetMapping("/{playerID}")
    public Integer getPoint(@PathVariable UUID playerID){
        return demo2.getSumOfPlayerPoints(playerID);
    }
}
