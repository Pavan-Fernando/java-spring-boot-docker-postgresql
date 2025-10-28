package com.spring.boot.docker.practice.docker.practice.controller;

import com.spring.boot.docker.practice.docker.practice.dto.UserDto;
import com.spring.boot.docker.practice.docker.practice.entity.User;
import com.spring.boot.docker.practice.docker.practice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @PostMapping
    public User addUser(@RequestBody UserDto user) {
        log.info("records adding started....");
        User user1 = new User();
        user1.setName(user.getName());
        user1.setEmail(user.getName());
        User creUser =  repo.save(user1);

        log.debug("This is a debug message");
        log.error("This is a test error log");

        log.info("records added, with user email{}", creUser.getEmail());
        return creUser;
    }
}
