package com.oded.msscbreweryclient.web.client;

import com.oded.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryRestClientTest {
    @Autowired
    BreweryRestClient client;

    @Test
    void testGetBeer() {
        BeerDto beerDto = client.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void testSaveNewBeer() {
        URI uri = client.saveNewBeer(getBeerDto());
        assertNotNull(uri);
        System.out.println(uri);
    }

    private static BeerDto getBeerDto() {
        return BeerDto.builder().beerName("My Beer").beerStyle("LAGER").build();
    }

    @Test
    void testUpdateBeer() {
        client.updateBeer(UUID.randomUUID(), getBeerDto());
    }

    @Test
    void testDeleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }
}