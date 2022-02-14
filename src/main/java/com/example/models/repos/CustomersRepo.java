package com.example.models.repos;

import java.util.List;

import com.example.models.entities.customers;

import org.springframework.data.repository.CrudRepository;

public interface CustomersRepo extends CrudRepository<customers, Long> {

    List<customers> findByNameContains(String name);
}
