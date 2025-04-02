package com.in28minutes.microservices.currencyconversionservice.adapter.in.dto;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Jacksonized
@Builder(toBuilder = true)
public record ConversionResponse(
        Long id,
        String from,
        String to,
        BigDecimal rate,
        BigDecimal quantity,
        BigDecimal conversionTotal,
        String environment
) {
}
