package astoppello.msscbrewery.service;

import astoppello.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService{

    @Override
    public List<BeerDto> getAllBeers() {
        return Collections.singletonList(BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build());
    }

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        beerDto.setId(UUID.randomUUID());
        return beerDto;
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        beerDto.setId(beerId);
    }

    @Override
    public void delete(UUID beerId) {

    }
}
