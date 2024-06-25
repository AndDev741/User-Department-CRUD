package com.anddev.user_department.controllers;

import com.anddev.user_department.entities.User;
import com.anddev.user_department.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class userController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> getUsers(){
        List<User> users = repository.findAll().stream().toList();
        return users;
    }

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable Long id){
        User user = repository.findById(id).get();
        return user;
    }

    @PostMapping
    public User insertUser(@RequestBody User user){
        User newUser = repository.save(user);
        return newUser;
    }

}
