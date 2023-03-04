package com.pks.spring3.controller;

import com.pks.spring3.Service.ServiceConsumptionUsingHttpExchange;
import com.pks.spring3.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service-consume")
public class ConsumedServiceTestController {

    @Autowired
    private ServiceConsumptionUsingHttpExchange consumptionUsingHttpExchange;

    @GetMapping("/rest/consumer")
    public List<Customer> fetchCustomer(){
        return consumptionUsingHttpExchange.findAllCustomer();
    }
}
