package com.example.controllers;

import com.example.models.entities.customers;
import com.example.services.CustomerService;

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
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public customers create(@RequestBody customers customers) {
        return customerService.post(customers);
    }

    @PutMapping
    public customers update(@RequestBody customers customers) {
        return customerService.put(customers);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        customerService.deleteById(id);
    }

    @GetMapping("/{id}")
    public customers searchById(@PathVariable Long id) {
        return customerService.searchById(id);
    }

    @GetMapping
    public Iterable<customers> searchAll() {
        return customerService.findAll();
    }
}
