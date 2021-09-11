package com.example.taskscheduler.controller;

import com.example.taskscheduler.model.User;
import com.example.taskscheduler.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/users")
@AllArgsConstructor
@Slf4j
public class UserController {

    private UserRepository repository;

    @PutMapping("/{userId}")
    public String upsertUser(@PathVariable("userId") String userId, @RequestBody User user) {
        log.info("Input request : {} {}", userId, user);
        user.setDeviceId(userId);
        User savedUser = repository.save(user);
        log.info("User updated as {}", savedUser);
        return "User details updated successfully!";
    }

    @GetMapping
    public List<User> getAllUsers() {
        return repository.findAll();
    }

}
