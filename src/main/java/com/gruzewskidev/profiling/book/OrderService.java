package com.gruzewskidev.profiling.book;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @SneakyThrows
    public BookOrder order(UUID bookID){
        Thread.sleep(100);
        return new BookOrder(bookID);
    }
}
