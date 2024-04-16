package com.gruzewskidev.profiling.demo3;

import com.gruzewskidev.profiling.book.BookStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.UUID;

@Service
public class WarehouseClient {
    private WebClient webClient;

    public WarehouseClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public BookStatus checkAvailability(UUID bookID){
       return webClient
               .get()
               .uri("https://91d4fc60-6e0f-44d1-9d23-7f25952489d1.mock.pstmn.io/api/" + bookID)
               .accept(MediaType.APPLICATION_JSON)
               .retrieve()
               .bodyToMono(BookStatus.class)
               .block();
    }
}
