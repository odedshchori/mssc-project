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
    public UUID addCustomer(CustomerDto customer) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .customerName("Joe Smith")
                .build().getId();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customer) {
        log.debug("update customer " + customerId.toString());
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("delete customer " + customerId.toString());
    }
}
