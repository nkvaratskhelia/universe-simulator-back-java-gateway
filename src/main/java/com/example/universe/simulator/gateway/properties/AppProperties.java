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
     * Service properties.
     */
    @Valid
    private ServiceProperties service = new ServiceProperties();

    @Getter @Setter
    public static class ServiceProperties {

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
