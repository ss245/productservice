package com.ecommerce.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
// Telling Hibernate to create a table for you.
@Entity(name = "ecomm_user")
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String email;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
