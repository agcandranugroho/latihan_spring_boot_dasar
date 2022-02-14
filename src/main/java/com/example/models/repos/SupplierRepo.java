package com.example.models.repos;

import java.util.List;

import com.example.models.entities.supplier;

import org.springframework.data.repository.CrudRepository;

public interface SupplierRepo extends CrudRepository<supplier, Long> {
    List<supplier> findByNameContains(String name);
}
