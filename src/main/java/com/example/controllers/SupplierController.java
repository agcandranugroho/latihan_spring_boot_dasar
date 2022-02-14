package com.example.controllers;

import com.example.models.entities.supplier;
import com.example.services.SupplierService;

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
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public supplier post(@RequestBody supplier supplier) {
        return supplierService.simpan(supplier);
    }

    @PutMapping
    public supplier update(@RequestBody supplier supplier) {
        return supplierService.update(supplier);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        supplierService.delete(id);
    }

    @GetMapping
    public Iterable<supplier> getAll() {
        return supplierService.getAll();
    }

    @GetMapping("/{id}")
    public supplier searchById(@PathVariable("id") Long id) {
        return supplierService.searchByID(id);
    }

}
