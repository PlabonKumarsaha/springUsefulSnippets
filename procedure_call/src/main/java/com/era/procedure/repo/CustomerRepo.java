package com.era.procedure.repo;

import com.era.procedure.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {

    //    @Query(value = "SELECT * FROM PLABON.CUSTOMER WHERE CUSTOMER.id = ?2;;",
//            nativeQuery = true)
//    public Customer getUser(@Param("id") Long id);


//    @Query(value = "SELECT * FROM PLABON.TRANSACTION WHERE SENDER_ID_ID = ?1;",
//            nativeQuery = true)
//    public Customer getSender(@Param("sender_id") Long id);


}
