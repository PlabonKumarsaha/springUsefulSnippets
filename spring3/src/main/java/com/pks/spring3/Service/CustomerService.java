package com.pks.spring3.Service;

import com.pks.spring3.dto.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
// localhost:8080/actuator/matrix
@Service
public class CustomerService {
  private List<Customer>customerList = new ArrayList<>();
  public Customer addCustomer(Customer customer){
    customerList.add(customer);
    return customer;
  }

  public List<Customer>getCustomerList(){
    return customerList;
  }

  public Customer getCustomerId(int id){
    return customerList.stream().filter(customer -> customer.id() ==id)
    .findAny().orElseThrow(()->new RuntimeException("Not found with such id"));
  }
}
