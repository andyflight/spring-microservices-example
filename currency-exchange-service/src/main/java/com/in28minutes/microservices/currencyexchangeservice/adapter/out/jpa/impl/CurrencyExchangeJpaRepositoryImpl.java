package com.in28minutes.microservices.currencyexchangeservice.adapter.out.jpa.impl;

import com.in28minutes.microservices.currencyexchangeservice.adapter.out.jpa.JpaCurrencyExchange;
import com.in28minutes.microservices.currencyexchangeservice.adapter.out.jpa.JpaCurrencyExchangeRepository;
import com.in28minutes.microservices.currencyexchangeservice.domain.models.CurrencyExchange;
import com.in28minutes.microservices.currencyexchangeservice.domain.repositories.CurrencyExchangeRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
@Primary
public class CurrencyExchangeJpaRepositoryImpl implements CurrencyExchangeRepository {

    private final JpaCurrencyExchangeRepository repository;

    @Override
    public Optional<CurrencyExchange> findByFromAndTo(String from, String to) {

        return repository.findByFromAndTo(from, to).map(JpaCurrencyExchange::toDomain);

    }
}
