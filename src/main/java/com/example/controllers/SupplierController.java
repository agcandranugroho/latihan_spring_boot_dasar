package com.example.controllers;

import javax.validation.Valid;

import com.example.DTO.ResponseData;
import com.example.models.entities.supplier;
import com.example.services.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
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
    public ResponseEntity<ResponseData<supplier>> post(@Valid @RequestBody supplier supplier, Errors errors) {
        ResponseData<supplier> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(supplierService.simpan(supplier));
        return ResponseEntity.ok().body(responseData);
    }

    @PutMapping
    public ResponseEntity<ResponseData<supplier>> update(@Valid @RequestBody supplier supplier, Errors errors) {
        ResponseData<supplier> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(supplierService.update(supplier));
        return ResponseEntity.ok().body(responseData);
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
