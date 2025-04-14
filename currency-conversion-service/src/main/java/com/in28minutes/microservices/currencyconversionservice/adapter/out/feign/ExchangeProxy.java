package com.in28minutes.microservices.currencyconversionservice.adapter.out.feign;

import com.in28minutes.microservices.currencyconversionservice.adapter.out.dao.ExchangeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange", url="localhost:8000")
//@FeignClient(name="currency-exchange")
//@FeignClient(name="currency-exchange", url="${CURRENCY_EXCHANGE_SERVICE_HOST:http://localhost}:8000")
@FeignClient(name="currency-exchange", url="${CURRENCY_EXCHANGE_BASE_URL:http://localhost}:8000")

public interface ExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    ExchangeResponse retrieveExchange(@PathVariable String from, @PathVariable String to);

}
