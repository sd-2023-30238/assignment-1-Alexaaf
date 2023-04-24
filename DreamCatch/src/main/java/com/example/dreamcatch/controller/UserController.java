package com.example.dreamcatch.controller;

import com.example.dreamcatch.model.User;
import com.example.dreamcatch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping(value = "/all")
    public List<User> getUsers(){
        return  userService.findAll();
    }

    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody User user)
    {
        userService.saveUser(user);
        return "New user added";
    }

    @PostMapping (value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User getUserToLogIn(@RequestBody User user)
    {
        User u = userService.findByEmailAndPassword(user);
        if(u != null)
        {
            System.out.println(u.toString());
            return u;

        }
        return null;
    }
}
