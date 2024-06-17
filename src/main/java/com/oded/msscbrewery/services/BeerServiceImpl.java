package com.oded.msscbrewery.services;

import com.oded.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beedId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Silver Moon")
                .beerStyle("Pale Ale")
                .build();
    }
}
