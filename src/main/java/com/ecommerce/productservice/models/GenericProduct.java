package com.ecommerce.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Data
@NoArgsConstructor
public class GenericProduct {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int price;

    public GenericProduct(String productName, int price) {
        this.name = productName;
        this.price = price;
    }
}
