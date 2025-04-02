package com.in28minutes.microservices.currencyexchangeservice.adapter.in.controllers;

import com.in28minutes.microservices.currencyexchangeservice.adapter.in.dto.CurrencyExchangeResponse;
import com.in28minutes.microservices.currencyexchangeservice.application.GetExchangeUseCase;
import com.in28minutes.microservices.currencyexchangeservice.domain.models.CurrencyExchange;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/currency-exchange")
@Slf4j
public class CurrencyExchangeController {

    private final GetExchangeUseCase getExchangeUseCase;
    private final Environment environment;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchangeResponse retrieveExchange(@PathVariable String from, @PathVariable String to) {
        CurrencyExchange exchange = getExchangeUseCase.getExchange(from, to);
        log.info("retrieve exchange from {} to {}", from, to);
        return CurrencyExchangeResponse.builder()
                .id(exchange.getId())
                .from(exchange.getFrom())
                .to(exchange.getTo())
                .rate(exchange.getRate())
                .environment(environment.getProperty("local.server.port"))
                .build();

    }
}
