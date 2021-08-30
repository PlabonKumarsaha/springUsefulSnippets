package com.pks.security.Service;

import com.pks.security.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User>list = new ArrayList<>();

    public UserService(){
        list.add(new User("abc","abc","abc@gmail.com"));
        list.add(new User("xyz","xyz","xyz@gmail.com"));
    }
    public List<User>getAllUser() {
        return this.list;
    }
    public User getUser(String userName) {
        return this.list.stream().filter((user) -> user.getUserName().equals(userName)).findAny().orElse(null);
    }

    public User addUser(User user) {
        list.add(user);
        return user;
    }
}
