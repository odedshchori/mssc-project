package com.oded.msscbrewery.web.mappers;

import com.oded.msscbrewery.domain.Customer;
import com.oded.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);
}
