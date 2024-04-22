package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dtos.GetProductDto;
import com.ecommerce.productservice.exceptions.NotFoundException;
import com.ecommerce.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {


    public GetProductDto getProductById(Long id) throws NotFoundException {


        RestTemplate restTemplate = new RestTemplate();

        String url = "https://fakestoreapi.com/products/" +id;

        Product product= restTemplate.getForObject(url, Product.class);

            System.out.println(product);

            if(product==null){
                throw new NotFoundException();
            }
        return convertToDto(product);
    }

    private static GetProductDto convertToDto(Product product) {
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

    public List<GetProductDto> getAllProducts() {
        // Make a call to 3rd party api.
        // Deserialize into Java object -> Array of Products.
        // Convert the array into array/list of Dto objects.

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products";
        Product[] products = restTemplate.getForObject(url, Product[].class);

        List<GetProductDto> returnProducts = new ArrayList<>();

        assert products != null;
        for(Product product : products) {
            returnProducts.add(convertToDto(product));
        }

        return returnProducts;
    }
}
