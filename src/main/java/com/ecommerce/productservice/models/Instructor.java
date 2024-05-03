package com.ecommerce.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class Instructor extends User{
    private Double salary;
    private String skill;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "instructor", cascade = CascadeType.REMOVE)
    private List<Batch> batch;
}
