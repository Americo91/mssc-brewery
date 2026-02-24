package astoppello.msscbrewery.service;

import astoppello.msscbrewery.web.model.CustomerDto;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void delete(UUID customerId);
}
