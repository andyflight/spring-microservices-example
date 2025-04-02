package com.in28minutes.microservices.currencyconversionservice.adapter.out.dao;

import java.math.BigDecimal;

public record ExchangeResponse(
        Long id,
        String from,
        String to,
        BigDecimal rate,
        String environment
) {
}
