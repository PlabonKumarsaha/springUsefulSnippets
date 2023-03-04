package com.pks.spring3.Service;


import com.pks.spring3.dto.Customer;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("/")
public interface ServiceConsumptionUsingHttpExchange {

    @GetExchange
    List<Customer> findAllCustomer();
}
