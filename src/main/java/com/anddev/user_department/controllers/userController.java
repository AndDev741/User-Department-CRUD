package com.anddev.user_department.controllers;

import com.anddev.user_department.entities.User;
import com.anddev.user_department.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
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
    public void insertUser(@RequestBody User user){
        User newUser = repository.save(user);
    }

    @PutMapping(value = "/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user){
        User updatedUser = repository.findById(id).orElseThrow();
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setDepartment(user.getDepartment());
        repository.save(updatedUser);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id){
        User deletedUser = repository.findById(id).orElseThrow();
        repository.delete(deletedUser);
    }


}
