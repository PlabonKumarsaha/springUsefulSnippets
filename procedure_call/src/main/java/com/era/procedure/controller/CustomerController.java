package com.era.procedure.controller;

import com.era.procedure.model.Customer;
import com.era.procedure.repo.CustomerRepo;
import com.era.procedure.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {


    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepo customerRepo;

    @GetMapping("/hey")
    public String sayHello() {
        return "Hello controller";
    }

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer customer){
        Customer cus = customerService.saveCustomer(customer);
        return  cus;
    }

    @GetMapping("/get/{id}")
    public Customer saveCustomer(@PathVariable("id") Long id){
        Customer cus = customerRepo.findById(id).get();
        return  cus;
    }
    @GetMapping("/procedurecall")
    public String callProdecure(
            @RequestParam(value = "actnum") String actnum,
            @RequestParam(value = "acttitle") String acttitle) {
        int code = customerService.incrementSalryWithActnameAndTitle(actnum,acttitle);

        if(code == 0){
            return "success";
        }else if (code == 1){
            return "failed";
        }else {
            return "exception";
        }
    }

}
