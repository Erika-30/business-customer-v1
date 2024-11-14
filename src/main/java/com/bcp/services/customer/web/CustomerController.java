package com.bcp.services.customer.web;

import com.bcp.services.account.api.CustomerControllerApiDelegate;
import com.bcp.services.account.model.CreateCustomerResponse;
import com.bcp.services.account.model.CustomerRequest;
import com.bcp.services.account.model.CustomerResponse;
import com.bcp.services.customer.business.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Product Controller.
 * This class is used to handle the product requests.
 */
@RequiredArgsConstructor
@Component
public class CustomerController implements CustomerControllerApiDelegate {

  private final CustomerService customerService;

  @Override
  public ResponseEntity<List<CustomerResponse>> customersGet(String requestId) {

    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  @Override
  public ResponseEntity<Void> customersIdDelete(String requestId,
                                                 String id) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  @Override
  public ResponseEntity<CustomerResponse> customersIdGet(String requestId,
                                                          String id) {

    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  @Override
  public ResponseEntity<CustomerResponse> customersIdPut(String requestId,
                                                          String id,
                                                          CustomerRequest customerRequest) {

    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  @Override
  public ResponseEntity<CreateCustomerResponse> customersPost(String requestId,
                                                               CustomerRequest customerRequest) {

    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

}