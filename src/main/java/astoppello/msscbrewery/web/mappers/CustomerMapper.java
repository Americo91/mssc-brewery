package astoppello.msscbrewery.web.mappers;

import astoppello.msscbrewery.domain.Customer;
import astoppello.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto toDto(Customer customer);
    Customer toDomain(CustomerDto customerDto);
}
