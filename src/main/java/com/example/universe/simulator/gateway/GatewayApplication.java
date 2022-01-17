package com.example.universe.simulator.gateway;

import com.example.universe.simulator.gateway.properties.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder, AppProperties properties) {
        return builder.routes()
            .route(predicate -> predicate
                .path("/entity-service/**")
                .uri(properties.getRoutes().getEntityServiceUrl()))
            .route(predicate -> predicate
                .path("/event-service/**")
                .uri(properties.getRoutes().getEventServiceUrl()))
            .build();
    }
}
