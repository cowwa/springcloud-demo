package com.example.serverwebflux;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author: cowwa
 * @Date: 2020/1/20 10:39
 * @Description:
 */
@SpringBootTest
@Slf4j
public class WebClientTest {
    @Test
    public void test(){
        WebClient client = WebClient.create("http://localhost:8091");
        ParameterizedTypeReference<ServerSentEvent<String>> type
                = new ParameterizedTypeReference<ServerSentEvent<String>>() {};

        Flux<ServerSentEvent<String>> eventStream = client.get()
                .uri("/stream-sse")
                .retrieve()
                .bodyToFlux(type);

        eventStream.subscribe(
                content -> log.info("Time: {} - event: name[{}], id [{}], content[{}] ",
                        LocalTime.now(), content.event(), content.id(), content.data()),
                error -> log.error("Error receiving SSE: {}", error),
                () -> log.info("Completed!!!"));
    }
}
