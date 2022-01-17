package com.example.universe.simulator.gateway.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
@Validated
@Getter @Setter
public class AppProperties {

    /**
     * Route properties.
     */
    @Valid
    private RouteProperties routes = new RouteProperties();

    @Getter @Setter
    public static class RouteProperties {

        /**
         * Entity service url.
         */
        @NotBlank
        private String entityServiceUrl;

        /**
         * Event service url.
         */
        @NotBlank
        private String eventServiceUrl;
    }
}
