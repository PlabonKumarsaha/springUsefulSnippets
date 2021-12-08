package com.pks.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class TestController {
    @Autowired
    TestRepo testRepo;

    @PostMapping()
    public TestEntity createPost( @RequestBody TestEntity testEntity){
        return testRepo.save(testEntity);
    }

    @GetMapping()
    public List<TestEntity> getAll(){
        return testRepo.findAll();
    }

    @GetMapping("/{id}")
    public TestEntity getOneByID(@PathVariable("id") long id){
        return testRepo.findById(id).get();
    }
}
