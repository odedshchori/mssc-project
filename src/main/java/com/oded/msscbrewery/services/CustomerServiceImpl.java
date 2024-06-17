package com.oded.msscbrewery.services;

import com.oded.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID beedId) {
        return CustomerDto.builder().
                id(UUID.randomUUID()).
                customerName("Joe Smith").
                build();
    }

    @Override
    public UUID addCustomer(CustomerDto beer) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .customerName("Joe Smith")
                .build().getId();
    }

    @Override
    public void updateCustomer(UUID beerId, CustomerDto beer) {
        log.debug("update beer " + beerId.toString());
    }

    @Override
    public void deleteCustomer(UUID beerId) {
        log.debug("delete beer " + beerId.toString());
    }
}
