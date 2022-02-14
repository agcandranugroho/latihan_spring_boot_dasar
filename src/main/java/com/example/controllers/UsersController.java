package com.example.controllers;

import com.example.models.entities.users;
import com.example.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserService usersService;

    @PostMapping
    public users create(@RequestBody users users) {
        return usersService.post(users);
    }

    @PutMapping
    public users update(@RequestBody users users) {
        return usersService.put(users);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        usersService.removeOne(id);
    }

    @GetMapping
    public Iterable<users> findAll() {
        return usersService.findAll();
    }

    @GetMapping("/{id}")
    public users findOne(@PathVariable("id") Long id) {
        return usersService.findOne(id);
    }

}
