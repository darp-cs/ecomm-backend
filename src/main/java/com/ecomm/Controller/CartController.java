package com.ecomm.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.Model.Cart;
import com.ecomm.Model.Product;
import com.ecomm.Service.CartService;
import com.ecomm.Service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/cart")
public class CartController {
    
    @Autowired
    CartService cartService;

    @GetMapping("/userCart")
    public ResponseEntity<Cart> fetchCartByUserId(@RequestParam Long userId){
        return ResponseEntity.ok(cartService.findByUserId(userId));
    }

    @PostMapping("/save")
    public ResponseEntity<Cart> saveCart(@RequestBody Cart cart){
        return  ResponseEntity.ok(cartService.save(cart));
    }
}
