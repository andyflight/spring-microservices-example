package com.in28minutes.microservices.currencyexchangeservice.adapter.in.controllers;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@Slf4j
@RestController
public class CircuitBreakerController {

    private final RestClient client = RestClient.create();

    @GetMapping("/sample-api")
    //@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    //@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    @Bulkhead(name="default")
    //@RateLimiter(name="default")
    public ResponseEntity<String> sampleApi(){

        log.info("Sample API call received");

        return ResponseEntity.ok("sampled");

//        String dummy = client.get()
//                .uri("http://localhost:8080/dummy")
//                .retrieve()
//                .body(String.class);
//
//        return ResponseEntity.ok(dummy);
    }

    public ResponseEntity<String> hardcodedResponse(Exception e){
        return ResponseEntity.ok("fallback Response");
    }

}
