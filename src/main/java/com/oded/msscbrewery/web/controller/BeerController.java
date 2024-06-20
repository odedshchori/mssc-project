package com.oded.msscbrewery.web.controller;


import com.oded.msscbrewery.services.BeerService;
import com.oded.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer/")
@RestController
public class BeerController {

    private final BeerService beerService;


    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return ResponseEntity.ok(beerService.getBeerById(beerId));
    }

    @PostMapping
    public ResponseEntity<Void> addBeer(@RequestBody BeerDto beer) {
        UUID uuid = beerService.addBeer(beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + uuid.toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{beerId}")
    public void updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beer) {
        beerService.updateBeer(beerId, beer);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{beerId}")
    public void delete(@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeer(beerId);
    }
}
