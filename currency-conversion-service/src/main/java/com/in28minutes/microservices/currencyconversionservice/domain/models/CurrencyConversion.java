package com.in28minutes.microservices.currencyconversionservice.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class CurrencyConversion {

    private Long id;
    private String from;
    private String to;
    private BigDecimal rate;
    private BigDecimal quantity;
    private BigDecimal conversionTotal;
    private String environment;


    public void conversion() {
        this.setConversionTotal(this.getQuantity().multiply(this.getRate()));
    }

}
