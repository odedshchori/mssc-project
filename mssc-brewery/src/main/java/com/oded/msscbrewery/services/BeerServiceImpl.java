package com.oded.msscbrewery.services;

import com.oded.msscbrewery.web.model.BeerDto;
import com.oded.msscbrewery.web.model.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Silver Moon")
                .beerStyle(BeerStyleEnum.PALE_ALE)
                .build();
    }

    @Override
    public BeerDto addBeer(BeerDto beer) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Silver Moon")
                .beerStyle(BeerStyleEnum.PALE_ALE)
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beer) {
        log.debug("update beer " + beerId.toString());
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("delete beer " + beerId.toString());
    }
}
