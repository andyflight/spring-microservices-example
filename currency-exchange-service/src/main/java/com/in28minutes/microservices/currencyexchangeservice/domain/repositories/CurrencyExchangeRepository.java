package com.in28minutes.microservices.currencyexchangeservice.domain.repositories;

import com.in28minutes.microservices.currencyexchangeservice.domain.models.CurrencyExchange;

import java.util.Optional;

public interface CurrencyExchangeRepository {

    Optional<CurrencyExchange> findByFromAndTo(String from, String to);
}
