package com.era.procedure.service;

import com.era.procedure.model.Customer;
import com.era.procedure.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.Map;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    private final static String INCREMENT_BALANCE_PROCEDURE = "PLABON.PRACTICE_PK.dpr_increase_balance";

    @Autowired
    private EntityManager entityManager;

    public int incrementSalryWithActnameAndTitle(String actnum, String acttit){
        System.out.println("actnum "+ actnum);
        System.out.println("acttit "+ acttit);
        StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery(INCREMENT_BALANCE_PROCEDURE);
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.OUT);
        query.setParameter(1, actnum);
        query.setParameter(2, acttit);
        int outputCode = (int) query.getOutputParameterValue(3);
        System.out.println("out code "+outputCode);
        return outputCode;
    }


    public Customer saveCustomer(Customer customer){
        Customer cus = customerRepo.save(customer);
        return cus;
    }


}
