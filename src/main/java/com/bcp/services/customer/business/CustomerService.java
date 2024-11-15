package com.bcp.services.customer.business;

import com.bcp.services.customer.model.CreateCustomerResponse;
import com.bcp.services.customer.model.CustomerRequest;
import com.bcp.services.customer.model.CustomerResponse;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerResponse> findAll();

    Optional<CustomerResponse> findById(Long id);

    Optional<CreateCustomerResponse> save(CustomerRequest request);

    Optional<CustomerResponse> update(String id, CustomerRequest customerRequest);

    void deleteById(Long id);
}
