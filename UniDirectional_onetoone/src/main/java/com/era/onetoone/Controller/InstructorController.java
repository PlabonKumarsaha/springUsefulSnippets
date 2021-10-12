package com.era.onetoone.Controller;

import com.era.onetoone.Reporsitory.InstructorRepo;
import com.era.onetoone.models.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstructorController {

    @Autowired
    InstructorRepo instructorRepo;

    @PostMapping("/isave")
    Instructor saveDate(@RequestBody Instructor instructor) {
        Instructor returnInst = instructorRepo.save(instructor);
        return returnInst;
    }

}
