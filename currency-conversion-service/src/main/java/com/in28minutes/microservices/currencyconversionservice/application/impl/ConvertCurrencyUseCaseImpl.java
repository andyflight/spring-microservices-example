package com.in28minutes.microservices.currencyconversionservice.application.impl;

import com.in28minutes.microservices.currencyconversionservice.application.ConvertCurrencyUseCase;
import com.in28minutes.microservices.currencyconversionservice.domain.models.CurrencyConversion;
import com.in28minutes.microservices.currencyconversionservice.domain.repositories.CurrencyConversionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class ConvertCurrencyUseCaseImpl implements ConvertCurrencyUseCase {

    private final CurrencyConversionRepository repository;

    @Override
    public CurrencyConversion convertCurrency(String fromCurrency, String toCurrency, BigDecimal quantity) {

        CurrencyConversion conversion = repository.getCurrencyConversion(fromCurrency, toCurrency);

        conversion.setQuantity(quantity);
        conversion.conversion();
        return conversion;
    }
}
