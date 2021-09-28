package com.era.procedure.service;


import com.era.procedure.model.Customer;
import com.era.procedure.model.Transaction;
import com.era.procedure.repo.CustomerRepo;
import com.era.procedure.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    TransactionRepo transactionRepo;

    public Transaction saveTransaction(Transaction transaction) {
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
        return transaction1;

    }
}
