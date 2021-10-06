package com.emp.repository;

import com.emp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "SELECT * FROM employee WHERE employee.id = :id AND employee.name LIKE %:name%",nativeQuery = true)
    Employee findByNameANDId(int id, String name);
}
