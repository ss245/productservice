package com.ecommerce.productservice.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

// Either use annotations like @Getter, @Setter or use methods like getName, setName.

@Getter
@Setter
@Data

public class Product {

/*
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private String category;
    private String seller;
*/
    // parameters according to fakestore apis response

    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;



    /*
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
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
     */
}
