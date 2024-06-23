package com.oded.msscbeerservice.web.mappers;

import com.oded.msscbeerservice.domain.Beer;
import com.oded.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper (uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtotoBeer(BeerDto beerDto);
}
