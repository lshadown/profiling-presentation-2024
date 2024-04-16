package com.gruzewskidev.profiling.demo3;

import com.gruzewskidev.profiling.book.BookOrder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/demo3")
public class Demo3Controller {

    private final Demo3 demo3;

    public Demo3Controller(Demo3 demo3) {
        this.demo3 = demo3;
    }

    @PostMapping("/{bookID}")
    public BookOrder bookOrder(@PathVariable UUID bookID){
         return demo3.orderBook(bookID);
    }
}
