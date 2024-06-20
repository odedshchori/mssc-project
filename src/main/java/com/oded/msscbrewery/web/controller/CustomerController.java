package com.oded.msscbrewery.web.controller;

import com.oded.msscbrewery.services.CustomerService;
import com.oded.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer/")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId) {
        return ResponseEntity.ok(service.getCustomerById(customerId));
    }


    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerDto customer) {
        UUID uuid = service.addCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + uuid.toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto beer) {
        service.updateCustomer(customerId, beer);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{customerId}")
    public void delete(@PathVariable("customerId") UUID customerId) {
        service.deleteCustomer(customerId);
    }
}
