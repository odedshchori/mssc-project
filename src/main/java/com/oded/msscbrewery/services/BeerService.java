package com.oded.msscbrewery.services;

import com.oded.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    UUID addBeer(BeerDto beer);

    void updateBeer(UUID beerId, BeerDto beer);

    void deleteBeer(UUID beerId);
}
