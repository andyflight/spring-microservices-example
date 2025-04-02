package com.in28minutes.microservices.currencyexchangeservice.adapter.in.dto;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Jacksonized
@Builder(toBuilder=true)
public record CurrencyExchangeResponse(
        Long id,
        String from,
        String to,
        BigDecimal rate,
        String environment
) {
}
