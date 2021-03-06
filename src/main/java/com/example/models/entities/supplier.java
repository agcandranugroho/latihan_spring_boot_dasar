package com.example.models.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "supplier")
public class supplier implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is required")
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @NotEmpty(message = "Alamat is required")
    @Column(name = "alamat", length = 200, nullable = false)
    private String alamat;

    @ManyToMany(mappedBy = "suppliers")
    private Set<products> products;

    public supplier() {
    }

    public supplier(Long id, String name, String alamat) {
        this.id = id;
        this.name = name;
        this.alamat = alamat;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Set<products> getProducts() {
        return products;
    }

    public void setProducts(Set<products> products) {
        this.products = products;
    }

}
