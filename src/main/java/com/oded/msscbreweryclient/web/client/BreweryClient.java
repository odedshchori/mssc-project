package com.oded.msscbreweryclient.web.client;

import com.oded.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class BreweryClient {
    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private final BreweryProperties breweryProperties;
    private final RestTemplate restTemplate;

    public BreweryClient(BreweryProperties breweryProperties, RestTemplateBuilder restTemplateBuilder) {
        this.breweryProperties = breweryProperties;
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(breweryProperties.getApihost() + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
    }
}
