package com.era.onetoone.Controller;

import com.era.onetoone.Reporsitory.InstructorRepo;
import com.era.onetoone.Reporsitory.UcourseRepo;
import com.era.onetoone.models.Instructor;
import com.era.onetoone.models.Ucourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UcourseController {

    @Autowired
    UcourseRepo ucourseRepo;
    @Autowired
    InstructorRepo instructorRepo;

    @PostMapping("/usave")
    public Ucourse saveData(@RequestBody Ucourse ucourse){
        Instructor instructor = instructorRepo.findById(ucourse.getInstructor().getIid()).orElse(null);

        if(instructor != null){
            ucourse.setInstructor(instructor);
        }

        Ucourse retucourse = ucourseRepo.save(ucourse);
        return retucourse;
    }
}
