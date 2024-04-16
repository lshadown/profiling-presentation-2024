package com.gruzewskidev.profiling;

import com.gruzewskidev.profiling.demo1.Demo1Controller;
import com.gruzewskidev.profiling.demo2.Demo2Controller;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.IntStream;

@Slf4j
@Component
public class WarmUp {
    private final Demo1Controller demo1Controller;
    private final Demo2Controller demo2Controller;

    public WarmUp(Demo1Controller demo1Controller, Demo2Controller demo2Controller) {
        this.demo1Controller = demo1Controller;
        this.demo2Controller = demo2Controller;
    }


    @PostConstruct
    void init(){
        log.info("Starting warm-up application");
        IntStream.range(0, 100)
                .parallel()
                .forEach(i -> {
                    demo1Controller.getPoint(UUID.randomUUID());
                    demo2Controller.getPoint(UUID.randomUUID());
                    log.info("I: {}", i);
                    i++;
                });

        log.info("End warm-up");
    }
}
