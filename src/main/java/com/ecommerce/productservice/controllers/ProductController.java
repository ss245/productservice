package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.dtos.GetProductDto;
import com.ecommerce.productservice.exceptions.NotFoundException;
import com.ecommerce.productservice.models.Product;
import com.ecommerce.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    /*
    @GetMapping("products/{id}")

    public String products(@PathVariable("id") Long id, @PathVariable("temp") String name){
        return "Here is your product id: "+id + " and temp: "+name;
    }
     */

    //@PostMapping("/products/{name}")
    // @RequestBody Product product converts received json object to product java object
    /*
    public String addProduct(@PathVariable("name") String name, @RequestBody Product product){

        System.out.println(product.getCategory());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getId());

        return "Product added successfully "+ name;
    }*/


    @PostMapping("")
    public ResponseEntity<String> createProduct(@RequestBody Product product){
        return ResponseEntity.ok("Here is price of your product: " + product.getPrice());
      //  return ResponseEntity.ok("Here is your product: " + product.getName());
    }

    //Dependency Injection

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public @ResponseBody GetProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
        return productService.getProductById(id);
    }


    // Create an API that will give all products
    @GetMapping("")
    public @ResponseBody List<GetProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

}
