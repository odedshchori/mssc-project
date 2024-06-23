package com.oded.msscbreweryclient.web.client;

import com.oded.msscbreweryclient.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.net.URI;
import java.util.UUID;

@Component
public class BreweryRestClient {
    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private final RestClient restClient;

    public BreweryRestClient(RestClient.Builder builder, BreweryProperties breweryProperties) {
        this.restClient = builder
                .baseUrl(breweryProperties.getApihost())
                .build();
    }

    public BeerDto getBeerById(UUID uuid){
        return restClient.get()
                .uri(BEER_PATH_V1 + uuid)
                .retrieve()
                .body(BeerDto.class);
    }


    public URI saveNewBeer(BeerDto beerDto) {
        ResponseEntity<Void> response = restClient.post()
                .uri(BEER_PATH_V1)
                .body(beerDto)
                .retrieve()
                .toEntity(Void.class);


        HttpHeaders headers = response.getHeaders();
        return headers.getLocation();
    }


    public void updateBeer(UUID uuid, BeerDto beerDto) {
        restClient.put()
                .uri(BEER_PATH_V1 + uuid)
                .body(beerDto)
                .retrieve();


    }

    public void deleteBeer(UUID uuid) {
        restClient.delete()
                .uri(BEER_PATH_V1 + uuid)
                .retrieve();
    }
}
