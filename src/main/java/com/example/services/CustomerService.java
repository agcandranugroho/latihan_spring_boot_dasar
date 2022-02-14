package com.example.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.example.models.entities.customers;
import com.example.models.repos.CustomersRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomersRepo customersRepo;

    public customers post(customers customers) {
        return customersRepo.save(customers);
    }

    public customers put(customers customers) {
        Optional<customers> optionalCustomers = customersRepo.findById(customers.getId());
        if (optionalCustomers.isPresent()) {
            return customersRepo.save(customers);
        }
        return null;
    }

    public customers searchById(Long id) {
        Optional<customers> optionalCustomers = customersRepo.findById(id);
        if (!optionalCustomers.isPresent()) {
            return null;
        }
        return optionalCustomers.get();
    }

    public Iterable<customers> findAll() {
        return customersRepo.findAll();
    }

    public void deleteById(Long id) {
        Optional<customers> optionalCustomers = customersRepo.findById(id);
        if (optionalCustomers.isPresent()) {
            customersRepo.delete(optionalCustomers.get());
        } else {
            throw new RuntimeException("Customer not found");
        }
    }
}
