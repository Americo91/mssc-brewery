package astoppello.msscbrewery.web.mappers;

import astoppello.msscbrewery.domain.Beer;
import astoppello.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto toDto(Beer beer);
    Beer toDomain(BeerDto beerDto);
}
