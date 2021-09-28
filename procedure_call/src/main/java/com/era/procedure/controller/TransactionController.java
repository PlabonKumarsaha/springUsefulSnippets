package com.era.procedure.controller;


import com.era.procedure.model.Customer;
import com.era.procedure.model.Transaction;
import com.era.procedure.repo.CustomerRepo;
import com.era.procedure.repo.TransactionRepo;
import com.era.procedure.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    TransactionRepo transactionRepo;



    @PostMapping("/saveTran")
    Transaction saveTransaction(@RequestBody Transaction transaction) {
        System.out.print("tran"+transaction);
        Customer sender = customerRepo.findById(transaction.getSenderId().getId()).orElse(null);
        if(sender!=null){
            System.out.println("sender"+sender);
            transaction.setSenderId(sender);
        }

        Customer reciever = customerRepo.findById(transaction.getRecieverId().getId()).orElse(null);

        if(reciever !=null) {
            System.out.println("reciever"+reciever);
            transaction.setRecieverId(reciever);
        }

        Transaction transaction1=transactionRepo.save(transaction);
        //  return transaction1;
        return transaction1;

    }
}

