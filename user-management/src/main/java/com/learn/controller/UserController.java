package com.learn.controller;

import com.learn.model.User;
import com.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return user;
    }

    //    @GetMapping("/")
//    public String hello(){
//        return "Hello";
//    }
    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable("userName") String username) {
        return userService.getUser(username);
    }
}
