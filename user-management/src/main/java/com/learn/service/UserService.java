package com.learn.service;

import com.learn.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User("abc", "ABC", "abc@gmail.com"));
        users.add(new User("xyz", "XYZ", "abc@gmail.com"));
    }

    public User getUser(String name) {
        return this.users.stream().filter((user) -> user.getName().equals(name)).findAny().orElse(null);
    }

    public List<User> getAllUsers() {
        return this.users;
    }
}

