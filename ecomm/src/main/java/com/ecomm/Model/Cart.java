package com.ecomm.Model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart implements Serializable{
    
    @Id
    @Column(name="cart_id")
    private Long cartId;

    @Column(name="user_id")
    private Long userId;

    @Column
    private String status;

    @Column(name="purchase_ts")
    private Timestamp purchaseTS;

    @CreationTimestamp
    @Column(name="created_ts")
    private Timestamp createdTS;

    @UpdateTimestamp
    @Column(name="updated_ts")
    private Timestamp updatedTS;

    @OneToMany
    private List<CartItem> cartItems;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

  
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getPurchaseTS() {
        return purchaseTS;
    }

    public void setPurchaseTS(Timestamp purchaseTS) {
        this.purchaseTS = purchaseTS;
    }

    public Timestamp getCreatedTS() {
        return createdTS;
    }

    public void setCreatedTS(Timestamp createdTS) {
        this.createdTS = createdTS;
    }

    public Timestamp getUpdatedTS() {
        return updatedTS;
    }

    public void setUpdatedTS(Timestamp updatedTS) {
        this.updatedTS = updatedTS;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

  
    

}
