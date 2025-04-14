package com.in28minutes.microservices.currencyconversionservice.adapter.in.controllers;

import com.in28minutes.microservices.currencyconversionservice.adapter.in.dto.ConversionResponse;
import com.in28minutes.microservices.currencyconversionservice.application.ConvertCurrencyUseCase;
import com.in28minutes.microservices.currencyconversionservice.domain.models.CurrencyConversion;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
@Slf4j
public class CurrencyConversionController {

    private final ConvertCurrencyUseCase convertCurrencyUseCase;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<ConversionResponse> convertCurrency(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
    ) {

        log.info("convert currency from {} to {} with quantity {}", from, to, quantity);

        CurrencyConversion conversion = convertCurrencyUseCase.convertCurrency(from, to, quantity);

        ConversionResponse response = ConversionResponse.builder()
                .id(conversion.getId())
                .from(conversion.getFrom())
                .to(conversion.getTo())
                .rate(conversion.getRate())
                .quantity(conversion.getQuantity())
                .conversionTotal(conversion.getConversionTotal())
                .environment(conversion.getEnvironment())
                .build();

        return ResponseEntity.ok(response);
    }
}
