package com.bcp.services.customer.business;

import com.bcp.services.customer.model.CreateCustomerResponse;
import com.bcp.services.customer.model.CustomerRequest;
import com.bcp.services.customer.model.CustomerResponse;
import com.bcp.services.customer.model.Customer;
import com.bcp.services.customer.repository.CustomerRepository;
import com.bcp.services.customer.util.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerResponse> findAll() {
        return customerRepository.findAll().stream()
                .map(customer -> new CustomerResponse()
                        .id(String.valueOf(customer.getId()))
                        .firstName(customer.getFirstName())
                        .lastName(customer.getLastName())
                        .dni(customer.getDni())
                        .email(customer.getEmail())).toList();
    }

    @Override
    public Optional<CustomerResponse> findById(Long id) {
        return customerRepository.findById(id)
                .map(customer -> new CustomerResponse()
                        .id(String.valueOf(customer.getId()))
                        .firstName(customer.getFirstName())
                        .lastName(customer.getLastName())
                        .dni(customer.getDni())
                        .email(customer.getEmail()));
    }

    @Override
    public Optional<CreateCustomerResponse>  save(CustomerRequest request) {

        if (customerRepository.findByDni(request.getDni()).isPresent()) {
            throw new ApiException("Customer with the same DNI already exists",
                    "business-customer-v1", "BC409",
                    HttpStatus.CONFLICT);
        }

        var customer = customerRepository.save(Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .dni(request.getDni())
                .email(request.getEmail())
                .build());

        return Optional.of(new CreateCustomerResponse()
                .id(String.valueOf(customer.getId())));
    }

    @Override
    public Optional<CustomerResponse> update(String id, CustomerRequest customerRequest) {
        var customerId = Long.valueOf(id);

        // Check if the customer with the provided ID exists
        var existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ApiException("Customer not found", "business-customer-v1",
                        "BC404",
                        HttpStatus.NOT_FOUND));

        // Check if there is another customer with the same DNI
        customerRepository.findByDni(customerRequest.getDni())
                .filter(customer -> !customer.getId().equals(customerId))
                .ifPresent(customer -> {
                    throw new ApiException("Customer with the same DNI already exists", "business-customer-v1",
                            "BC409",
                            HttpStatus.CONFLICT);
                });

        // Update the customer details
        existingCustomer.setFirstName(customerRequest.getFirstName());
        existingCustomer.setLastName(customerRequest.getLastName());
        existingCustomer.setDni(customerRequest.getDni());
        existingCustomer.setEmail(customerRequest.getEmail());

        // Save the updated customer
        var updatedCustomer = customerRepository.save(existingCustomer);

        // Return the updated customer response
        return Optional.of(new CustomerResponse().id(String.valueOf(updatedCustomer.getId())));
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);

    }
}
