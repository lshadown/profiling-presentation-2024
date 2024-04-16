package com.gruzewskidev.profiling.demo3;

import com.gruzewskidev.profiling.book.*;
import com.gruzewskidev.profiling.demo3.exception.BookNotAvailableException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Demo3 {
    private final WarehouseClient warehouseClient;
    private final OrderService orderService;
    private final Shipment shipment;

    public Demo3(WarehouseClient warehouseClient, OrderService orderService, Shipment shipment) {
        this.warehouseClient = warehouseClient;
        this.orderService = orderService;
        this.shipment = shipment;
    }

    public BookOrder orderBook(UUID bookID){
        BookStatus status = warehouseClient.checkAvailability(bookID);
        if(status.isAvailable()){
            BookOrder bookOrder = orderService.order(bookID);
            shipment.createShipment(bookOrder);
            return bookOrder;
        }
        throw new BookNotAvailableException("book.not.available");
    }
}
