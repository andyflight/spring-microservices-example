package com.in28minutes.microservices.currencyexchangeservice.adapter.out.stub;

import com.in28minutes.microservices.currencyexchangeservice.domain.models.CurrencyExchange;
import com.in28minutes.microservices.currencyexchangeservice.domain.repositories.CurrencyExchangeRepository;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Deprecated
@Repository
public class CurrencyExchangeStubRepositoryImpl implements CurrencyExchangeRepository {

    @Override
    public Optional<CurrencyExchange> findByFromAndTo(String from, String to){
        return Optional.of(new CurrencyExchange(1001L, from, to, BigDecimal.valueOf(3.55)));
    }
}
