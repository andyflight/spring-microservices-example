package com.in28minutes.microservices.currencyexchangeservice.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurrencyExchange {

    private Long id;
    private String from;
    private String to;
    private BigDecimal rate;

}
