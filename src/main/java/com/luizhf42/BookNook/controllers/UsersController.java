package com.luizhf42.BookNook.controllers;

import com.luizhf42.BookNook.models.User;
import com.luizhf42.BookNook.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
