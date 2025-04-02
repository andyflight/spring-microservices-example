package com.in28minutes.microservices.apigateway.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiRouterConfig {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(p -> p.path("/get")
                                     .filters(f -> f
                                             .addRequestHeader("MyHeader", "MyURI")
                                             .addRequestParameter("MyParam", "MyValue"))
                                     .uri("https://httpbin.org"))
                .route(p -> p.path("/currency-exchange/**")
                        .uri("lb://currency-exchange")
                )
                .route(p -> p.path("/currency-conversion/**")
                        .uri("lb://currency-conversion")
                )
                .route(p -> p.path("/currency-conversion-new/**")
                        .filters(f -> f.rewritePath(
                                "/currency-conversion-new/(?<segment>.*)",
                                "/currency-conversion/${segment}"
                        ))
                        .uri("lb://currency-conversion")
                )
                .build();
    }
}
