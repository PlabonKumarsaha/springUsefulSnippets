package com.pks.security.Controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {

    @GetMapping("/home")
    public String getHome() {
        return "This Is Home";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "This Is login";
    }

    @GetMapping("/reg")
    public String getReg() {
        return "This Is Reg";
    }

}
