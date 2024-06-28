package com.oded.msscbreweryclient.web.client;

import com.oded.msscbreweryclient.web.model.BeerDto;
import com.oded.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto dto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer() {
        BeerDto newBeer = BeerDto.builder().beerName("New Beer").build();
        URI uri = breweryClient.saveNewBeer(newBeer);
        assertNotNull(uri);

        System.out.println(uri);
    }

    @Test
    void testUpdateBeer() {
        BeerDto beer = BeerDto.builder().beerName("New Beer").build();
        breweryClient.updateBeer(UUID.randomUUID(), beer);
    }

    @Test
    void testDeleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }


    @Test
    void getCustomerById() {
        CustomerDto customer = breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customer);
    }

    @Test
    void testAddNewCustomer() {
        URI uri = breweryClient.addNewCustomer(CustomerDto.builder().build());
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void testUpdateCustomer() {
        breweryClient.udpateCustomer(UUID.randomUUID(), CustomerDto.builder().build());
    }

    @Test
    void testDeleteCustomer() {
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}