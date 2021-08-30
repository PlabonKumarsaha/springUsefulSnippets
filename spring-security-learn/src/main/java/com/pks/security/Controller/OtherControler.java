package com.pks.security.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//checking PreAuthorization

@RestController
public class OtherControler {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/col")
    public String getCollect() {
        return "This Is Reg";
    }

    @GetMapping("/signIn")
    public String signIn() {
        return "templates/login.html";
    }

}
