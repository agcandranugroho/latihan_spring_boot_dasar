package com.example.models.repos;

import java.util.List;

import com.example.models.entities.products;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<products, Long> {

    List<products> findByNameContains(String name);
}
