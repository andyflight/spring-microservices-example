package com.in28minutes.microservices.currencyexchangeservice.adapter.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaCurrencyExchangeRepository extends JpaRepository<JpaCurrencyExchange, Long> {

    Optional<JpaCurrencyExchange> findByFromAndTo(String from, String to);

}
