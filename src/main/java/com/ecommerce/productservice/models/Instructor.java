package com.ecommerce.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.repository.cdi.Eager;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class Instructor extends User{
    private Double salary;
    private String skill;
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.REMOVE)
    @Fetch(FetchMode.JOIN)
    private List<Batch> batch;
}
