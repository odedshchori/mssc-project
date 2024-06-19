package com.oded.msscbreweryclient.web.client;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@Getter
@Setter
@ConfigurationProperties(value = "sfg.brewery")
public class BreweryProperties {
    private String apihost;

    private BreweryProperties() {
    }
}
