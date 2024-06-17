package com.oded.msscbrewery.services;

import com.oded.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID beedId) {
        return CustomerDto.builder().
                id(UUID.randomUUID()).
                customerName("Joe Smith").
                build();
    }
}
