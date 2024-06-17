package com.oded.msscbrewery.web.controller;

import com.oded.msscbrewery.services.CustomerService;
import com.oded.msscbrewery.web.model.CustomerDto;
import com.sun.net.httpserver.Headers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId) {
        return ResponseEntity.ok(service.getCustomerById(customerId));
    }


    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerDto beer) {
        UUID uuid = service.addCustomer(beer);
        Headers headers = new Headers();
        headers.add("Location", "/api/v1/beer/" + uuid.toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{beerId}")
    public void updateCustomer(@PathVariable("beerId") UUID beerId, @RequestBody CustomerDto beer) {
        service.updateCustomer(beerId, beer);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{beerId}")
    public void delete(@PathVariable("beerId") UUID beerId) {
        service.deleteCustomer(beerId);
    }
}
