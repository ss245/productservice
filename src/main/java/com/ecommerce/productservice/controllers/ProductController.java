package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.models.Product;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/products")
public class ProductController {

    @GetMapping("/products/{id}/{temp}")

    public String GetProductById(@PathVariable("id") Long id) {
        return "Here is your product by id: " + id;
    }
    //public String getProductById(@PathVariable("id") Long id){
      //  return "Here is product id: "+id;
    //}
    public String products(@PathVariable("id") Long id, @PathVariable("temp") String name){
        return "Here is your product id: "+id + " and temp: "+name;
    }

    @PostMapping("/products/{name}")
    // @RequestBody Product product converts received json object to product java object
    public String addProduct(@PathVariable("name") String name, @RequestBody Product product ){

        System.out.println(product.getCategory());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getId());

        return "Product added successfully "+ name;
    }
}
