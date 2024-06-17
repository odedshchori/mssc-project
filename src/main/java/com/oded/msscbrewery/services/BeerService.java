package com.oded.msscbrewery.services;

import com.oded.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beedId);
}
