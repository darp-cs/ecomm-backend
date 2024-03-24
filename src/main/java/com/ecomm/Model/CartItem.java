package com.ecomm.Model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ecomm.Model.CompositeKey.CartItemId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


//@IdClass specifies the composite key for an object that has more than one row as a primary key
@Entity
@Table(name= "cart_item")
@IdClass(CartItemId.class)
//By implementing Serializable we can represent an objects state as a byte stream
public class CartItem implements Serializable{
    
    @Id
    @Column(name="item_id")
    private Long itemId;

    @Id
    @ManyToOne
    @JoinColumn(name="cart_id")
    private Long cartId;

    @Id
    @Column(name="product_id")
    private Long productId;


    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column
    private Long quantity;

    @Column
    private String status;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    
    

    
}
