package com.bcp.services.customer.business;


import com.bcp.services.customer.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll() ;

    Optional<Customer> findById(Long id) ;

    Customer save(Customer customer) ;

    void deleteById(Long id) ;
}
