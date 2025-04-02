package com.in28minutes.microservices.currencyconversionservice.adapter.out.feign;

import com.in28minutes.microservices.currencyconversionservice.adapter.out.dao.ExchangeResponse;
import com.in28minutes.microservices.currencyconversionservice.domain.models.CurrencyConversion;
import com.in28minutes.microservices.currencyconversionservice.domain.repositories.CurrencyConversionRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
@AllArgsConstructor
public class CurrencyConversionFeignRepository implements CurrencyConversionRepository {

    private final ExchangeProxy proxy;


    @Override
    public CurrencyConversion getCurrencyConversion(String fromCurrency, String toCurrency) {

        ExchangeResponse response = proxy.retrieveExchange(fromCurrency, toCurrency);

        return new CurrencyConversion(
                response.id(),
                response.from(),
                response.to(),
                response.rate(),
                null,
                null,
                response.environment()+" feign"
        );
    }

}
