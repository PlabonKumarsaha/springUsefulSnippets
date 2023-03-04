package com.pks.spring3.controller;

import com.pks.spring3.Service.CustomerService;
import com.pks.spring3.dto.Customer;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  private CustomerService customerService;
  private ObservationRegistry observationRegistry;

  public CustomerController(CustomerService customerService, ObservationRegistry observationRegistry) {
    this.customerService = customerService;
    this.observationRegistry = observationRegistry;
  }
  @PostMapping
  public Customer addCustomer(@RequestBody() Customer customer){
    customerService.addCustomer(customer);
    return Observation.createNotStarted("createCustomer",observationRegistry)
        .observe(()->customer);
  }

  @GetMapping
  public List<Customer> getCustomerList(){
    return Observation.createNotStarted("getAllCustomers",observationRegistry)
        .observe(()->customerService.getCustomerList());
  }

  @GetMapping("/{id}")
  public Customer getEachCustomer(@PathVariable int id){
    return Observation.createNotStarted("getAllCustomer",observationRegistry)
        .observe(()->customerService.getCustomerId(id));
  }

}
