package com.in28minutes.microservices.currencyexchangeservice.adapter.out.jpa;

import com.in28minutes.microservices.currencyexchangeservice.domain.models.CurrencyExchange;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class JpaCurrencyExchange {

    @Id
    private Long id;

    @Column(name="currency_from")
    private String from;

    @Column(name="currency_to")
    private String to;

    private BigDecimal rate;


    public CurrencyExchange toDomain(){
        return new CurrencyExchange(
                this.id,
                this.from,
                this.to,
                this.rate
        );
    }
}
