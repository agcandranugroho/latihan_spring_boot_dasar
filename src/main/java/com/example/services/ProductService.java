package com.example.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.models.entities.products;
import com.example.models.repos.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public products save(products product) {
        return productRepo.save(product);
    }

    public products update(products product) {
        Optional<products> optionalProduct = productRepo.findById(product.getId());
        if (optionalProduct.isPresent()) {
            return productRepo.save(product);
        }
        return null;
    }

    public products findOne(Long id) {
        Optional<products> optionalProduct = productRepo.findById(id);
        if (!optionalProduct.isPresent()) {
            return null;
        }
        return productRepo.findById(id).get();
    }

    public Iterable<products> findAll() {
        return productRepo.findAll();
    }

    public void removeOne(Long id) {
        Optional<products> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()) {
            productRepo.delete(optionalProduct.get());
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    public List<products> findByName(String name) {
        return productRepo.findByNameContains(name);
    }
}
