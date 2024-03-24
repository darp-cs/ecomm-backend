package com.ecomm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.Model.Cart;
import java.util.List;



public interface CartRepository extends JpaRepository<Cart, Long>{
    
    Cart findByUserId(Long userId);
}
