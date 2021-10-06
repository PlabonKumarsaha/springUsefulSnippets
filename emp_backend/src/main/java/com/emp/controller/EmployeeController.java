package com.emp.controller;

import com.emp.exception.EmpException;
import com.emp.model.Employee;
import com.emp.repository.EmpRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
    EmpRepository empRepository;


    @PostMapping("emp")
    Employee postData(@RequestBody Employee employee){
        Employee returnData = empRepository.save(employee);
        return returnData;
    }

    @GetMapping("emp")
    List<Employee> getAllData(){
        List<Employee> returnData = empRepository.findAll();
        return returnData;
    }

    @GetMapping("emp/{id}")
    Employee getDataById(@PathVariable("id") Integer id){
        Employee returnData = empRepository.findById(id).get();
        return returnData;
    }

    //http://localhost:8088/api/v1/empbyId/?id=1&name=plabon
    @GetMapping("empbyId")
    Employee getDataByNameId(@RequestParam Integer id,@RequestParam String name){
        Employee returnData = empRepository.findByNameANDId(id,name);
        return returnData;
    }

    @PutMapping("emp/{id}")
    Employee updateDataById(@RequestBody Employee update,@PathVariable("id") Integer id){
        Employee findEmp = empRepository.findById(id).get();
        findEmp.setEmpId(update.getEmpId());
        findEmp.setName(update.getName());
        findEmp.setSalary(update.getSalary());
        empRepository.save(findEmp);
        return findEmp;
    }

    @DeleteMapping("emp/{id}")
    String deleteDataById(@PathVariable("id") Integer id){
         empRepository.deleteById(id);
        return "deleted";
    }



}
