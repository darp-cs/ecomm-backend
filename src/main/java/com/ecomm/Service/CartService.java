package com.ecomm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.Model.Cart;
import com.ecomm.Repository.CartRepository;

@Service
public class CartService {
    

    @Autowired
    CartRepository cartRepository;

    public Cart findByUserId(Long userId){
        return cartRepository.findByUserId(userId);
    }

    public Cart save(Cart cart){
        return cartRepository.save(cart);
    }
}
