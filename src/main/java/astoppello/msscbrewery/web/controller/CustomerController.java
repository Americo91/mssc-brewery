package astoppello.msscbrewery.web.controller;

import astoppello.msscbrewery.service.CustomerService;
import astoppello.msscbrewery.web.model.CustomerDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(CustomerController.CUSTOMER_URL_PATH)
@RequiredArgsConstructor
public class CustomerController {

    public static final String CUSTOMER_URL_PATH = "/api/v1/customer";
    public static final String CUSTOMER_ID_PATH = "/{customerId}";
    private final CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping(CUSTOMER_ID_PATH)
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CustomerDto> handlePost(@RequestBody @Valid CustomerDto customerDto) {
        CustomerDto savedCustomer = customerService.saveNewCustomer(customerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", CUSTOMER_URL_PATH + "/" + savedCustomer.getId().toString());
        return new ResponseEntity<>(savedCustomer, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping(CUSTOMER_ID_PATH)
    public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody @Valid CustomerDto customerDto) {
        customerService.updateCustomer(customerId, customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(CUSTOMER_ID_PATH)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
        customerService.delete(customerId);
    }
}
