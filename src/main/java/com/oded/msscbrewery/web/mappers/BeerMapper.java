package com.oded.msscbrewery.web.mappers;


import com.oded.msscbrewery.domain.Beer;
import com.oded.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper (uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtotoBeer(BeerDto beerDto);
}
