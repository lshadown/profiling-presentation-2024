package com.gruzewskidev.profiling.book;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class Shipment {

    @SneakyThrows
    public void createShipment(BookOrder bookOrder){
        Thread.sleep(150);
    }
}
