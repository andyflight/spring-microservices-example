package com.in28minutes.microservices.currencyconversionservice.domain.repositories;

import com.in28minutes.microservices.currencyconversionservice.domain.models.CurrencyConversion;

public interface CurrencyConversionRepository {

    CurrencyConversion getCurrencyConversion(String fromCurrency, String toCurrency);

}
