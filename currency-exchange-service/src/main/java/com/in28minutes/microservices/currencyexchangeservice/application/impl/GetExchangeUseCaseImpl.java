package com.in28minutes.microservices.currencyexchangeservice.application.impl;

import com.in28minutes.microservices.currencyexchangeservice.application.GetExchangeUseCase;
import com.in28minutes.microservices.currencyexchangeservice.domain.models.CurrencyExchange;
import com.in28minutes.microservices.currencyexchangeservice.domain.repositories.CurrencyExchangeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class GetExchangeUseCaseImpl implements GetExchangeUseCase {

    private final CurrencyExchangeRepository repository;

    @Override
    @Transactional(readOnly = true)
    public CurrencyExchange getExchange(String from, String to) {
        return repository.findByFromAndTo(from, to)
                .orElseThrow(() -> new RuntimeException("Currency Exchange not found"));
    }
}
