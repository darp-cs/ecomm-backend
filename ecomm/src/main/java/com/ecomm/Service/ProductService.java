package com.ecomm.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.Model.Product;
import com.ecomm.Repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    ProductRepository productRepository;

    public ArrayList<Product> fetchAllProducts(){
        return productRepository.findAll();
    }

    
}
