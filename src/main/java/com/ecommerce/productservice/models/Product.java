package com.ecommerce.productservice.models;

import lombok.Getter;
import lombok.Setter;


public class Product {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private String category;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
