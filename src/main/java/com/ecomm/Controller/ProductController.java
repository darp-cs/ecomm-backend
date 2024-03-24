package com.ecomm.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.Model.Product;
import com.ecomm.Service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    ProductService productService;


    @GetMapping("/")
    public ResponseEntity<ArrayList<Product>> fetchAllProducts(){
        return ResponseEntity.ok(productService.fetchAllProducts());
    }
}
