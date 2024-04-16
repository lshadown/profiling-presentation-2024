package com.gruzewskidev.profiling.demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/demo1")
public class Demo1Controller {
    private Demo1 demo1;

    public Demo1Controller(Demo1 demo1) {
        this.demo1 = demo1;
    }

    @GetMapping("/{playerID}")
    public Integer getPoint(@PathVariable UUID playerID){
        return demo1.getSumOfPlayerPoints(playerID);
    }
}
