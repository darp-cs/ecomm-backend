package com.ecomm.Dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomm.Model.Product;
import com.ecomm.Repository.ProductRepository;

@Component
public class ProductDao implements Dao{

    @Autowired
    ProductRepository productRepository;


    @Override
    public Object get(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public ArrayList<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Object t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(Object t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
