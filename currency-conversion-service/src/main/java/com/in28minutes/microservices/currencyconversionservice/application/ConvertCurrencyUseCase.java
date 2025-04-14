package com.in28minutes.microservices.currencyconversionservice.application;

import com.in28minutes.microservices.currencyconversionservice.domain.models.CurrencyConversion;

import java.math.BigDecimal;

public interface ConvertCurrencyUseCase {

    CurrencyConversion  convertCurrency(String fromCurrency, String toCurrency, BigDecimal quantity);

}
