package com.oded.msscbrewery.services;

import com.oded.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID beedId);
}
