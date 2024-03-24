package com.ecomm.Repository;

import org.springframework.stereotype.Repository;

import com.ecomm.Model.Product;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
    public ArrayList<Product> findAll();

}
