package astoppello.msscbrewery.service;

import astoppello.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<CustomerDto> getAllCustomers() {
        return Collections.singletonList(CustomerDto.builder()
                .id(UUID.randomUUID())
                .customerName("John Doe")
                .build());
    }

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .customerName("John Doe")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        customerDto.setId(UUID.randomUUID());
        return customerDto;
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        customerDto.setId(customerId);
    }

    @Override
    public void delete(UUID customerId) {

    }
}
