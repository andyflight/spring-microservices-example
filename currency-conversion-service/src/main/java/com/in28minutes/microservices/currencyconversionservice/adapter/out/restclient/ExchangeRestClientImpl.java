package com.in28minutes.microservices.currencyconversionservice.adapter.out.restclient;

import com.in28minutes.microservices.currencyconversionservice.adapter.out.dao.ExchangeResponse;
import com.in28minutes.microservices.currencyconversionservice.domain.models.CurrencyConversion;
import com.in28minutes.microservices.currencyconversionservice.domain.repositories.CurrencyConversionRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

@Repository
@Deprecated
public class ExchangeRestClientImpl implements CurrencyConversionRepository{

    private final RestClient restClient;

    private final String url;

    public ExchangeRestClientImpl() {
        this.restClient = RestClient.create();
        this.url = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";
    }

    private ExchangeResponse clientCall(String fromCurrency, String toCurrency) {
        return restClient.get()
                .uri(url, uriBuilder -> uriBuilder.build(fromCurrency, toCurrency))
                .retrieve()
                .onStatus(HttpStatusCode::isError,(request, response) -> {
                    throw new RuntimeException(response.getStatusText());
                })
                .body(ExchangeResponse.class);
    }

    @Override
    public CurrencyConversion getCurrencyConversion(String fromCurrency, String toCurrency) {

        ExchangeResponse response = clientCall(fromCurrency, toCurrency);

        return new CurrencyConversion(
                response.id(),
                response.from(),
                response.to(),
                response.rate(),
                null,
                null,
                response.environment()+" rest client"
        );
    }
}
