package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dtos.GetProductDto;
import com.ecommerce.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {


    public GetProductDto getProductById(Long id) {


        RestTemplate restTemplate = new RestTemplate();

        String url = "https://fakestoreapi.com/products/" +id;

        Product product= restTemplate.getForObject(url, Product.class);

            System.out.println(product);


            GetProductDto obj = new GetProductDto();
            /*
            obj.setName("Iphone");
            obj.setPrice(150000.0);
            obj.setImageUrl("www.apple.com");
             */
        obj.setName(product.getTitle());
        obj.setPrice(product.getPrice());
        obj.setImageUrl(product.getImage());
        return obj;
    }
}
