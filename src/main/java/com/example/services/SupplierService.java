package com.example.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.example.models.entities.supplier;
import com.example.models.repos.SupplierRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    public supplier simpan(supplier supplier) {
        return supplierRepo.save(supplier);
    }

    public supplier update(supplier supplier) {
        Optional<supplier> optionalSupplier = supplierRepo.findById(supplier.getId());
        if (optionalSupplier.isPresent()) {
            return supplierRepo.save(supplier);
        }
        return null;

    }

    public void delete(Long id) {
        Optional<supplier> optionalSupplier = supplierRepo.findById(id);
        if (optionalSupplier.isPresent()) {
            supplierRepo.delete(optionalSupplier.get());
        } else {
            throw new RuntimeException("Data Tidak Ada");
        }
    }

    public Iterable<supplier> getAll() {
        return supplierRepo.findAll();
    }

    public supplier searchByID(Long id) {
        Optional<supplier> optionalSupplier = supplierRepo.findById(id);
        if (optionalSupplier.isPresent()) {
            return supplierRepo.findById(id).get();
        }
        return null;
    }

}
