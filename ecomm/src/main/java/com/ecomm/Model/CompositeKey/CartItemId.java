package com.ecomm.Model.CompositeKey;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class CartItemId implements Serializable{

     /* @Column
     *        Name is specified because the name in the table uses underscore, we use camel case for the variables as best practice
     *        This value should also be unique for this column so we specify that as well
     *        Finally the field should not be null, this is taken care of by generated value but we specify so the developer is aware
     */
    @Column(name="cart_id")
    private Long cartId;
    
    @Column(name="product_id")
    private Long productId;

    @Column(name="item_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long itemId;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
    
    
}
