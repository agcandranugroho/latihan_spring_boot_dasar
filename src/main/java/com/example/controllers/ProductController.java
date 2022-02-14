package com.example.controllers;

import com.example.models.entities.products;
import com.example.services.ProductService;

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
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public products create(@RequestBody products product) {
        return productService.save(product);
    }

    @PutMapping
    public products update(@RequestBody products product) {
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        productService.removeOne(id);
    }

    @GetMapping
    public Iterable<products> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public products findOne(@PathVariable("id") Long id) {
        return productService.findOne(id);
    }

}
