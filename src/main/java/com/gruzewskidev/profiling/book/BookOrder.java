package com.gruzewskidev.profiling.book;

import lombok.Data;

import java.util.UUID;

@Data
public class BookOrder {
    private UUID id;
    private UUID bookID;

    public BookOrder(UUID bookID) {
        this.id = UUID.randomUUID();
        this.bookID = bookID;
    }
}
