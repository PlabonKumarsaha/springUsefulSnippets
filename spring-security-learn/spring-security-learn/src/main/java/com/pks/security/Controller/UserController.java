package com.pks.security.Controller;

import com.pks.security.Model.User;
import com.pks.security.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;



    //get all user
    @GetMapping("/")
    public List<User> getAllUser() {
        return this.userService.getAllUser();
    }
    @GetMapping("/{username}")
    public User getUserbyUserName(@PathVariable("username") String userName) {
        return this.userService.getUser(userName);
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }
}
