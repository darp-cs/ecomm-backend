package com.ecomm.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.Dao.ProductDao;
import com.ecomm.Model.Product;

@Service
public class ProductService {
    
    @Autowired
    ProductDao productDao;

    public ArrayList<Product> fetchAllProducts(){
        return productDao.getAll();
    }

    
}
