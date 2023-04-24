package com.luizhf42.BookNook.controllers;

import com.luizhf42.BookNook.models.User;
import com.luizhf42.BookNook.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable String id) {
        Optional<User> user = userRepository.findById(id);

        return user.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(user);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity.status(409).body("Username already exists");
        }
        userRepository.save(user);
        URI uri = URI.create("http://localhost:8080/users/" + user.getId());
        return ResponseEntity.created(uri).body(user);
    }
}
