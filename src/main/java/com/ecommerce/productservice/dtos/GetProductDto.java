package com.ecommerce.productservice.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GetProductDto {
    private String name;
    private double price;
    private String imageUrl;
}
