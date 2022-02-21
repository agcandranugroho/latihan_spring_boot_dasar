package com.example.models.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class products implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id

    // anotasi untuk auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name product is required")
    @Column(name = "product_name", length = 100, nullable = false)
    private String name;

    @NotEmpty(message = "Product description is required")
    @Column(name = "product_description", length = 100, nullable = false)
    private String description;

    @NotNull(message = "Price is required")
    @Column(name = "product_price", length = 100, nullable = false)
    private Double price;

    // relasi dengan entity class category
    @ManyToOne
    private category category;

    @ManyToMany
    @JoinTable(name = "product_supplier", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private Set<supplier> suppliers;

    public products() {
    }

    public products(Long id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public category getCategory() {
        return category;
    }

    public void setCategory(category category) {
        this.category = category;
    }

    public Set<supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<supplier> suppliers) {
        this.suppliers = suppliers;
    }

}
