package com.ecommerce.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Batch {
    @Id
    private Long id;
    private String name;
    private Integer strength;
    @ManyToOne
    private Instructor instructor;
}
