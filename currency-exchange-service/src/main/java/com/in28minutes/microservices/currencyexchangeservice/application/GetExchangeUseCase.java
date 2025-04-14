package com.in28minutes.microservices.currencyexchangeservice.application;

import com.in28minutes.microservices.currencyexchangeservice.domain.models.CurrencyExchange;

public interface GetExchangeUseCase {

    CurrencyExchange getExchange(String from, String to);

}
