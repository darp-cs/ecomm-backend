package com.ecomm.Model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//By implementing Serializable we can represent an objects state as a byte stream
public class Product implements Serializable{

    /*@Id Specifies this is the primary key for this table
     * @GeneratedValue Specifies that this value will be auto generated if not provided as the next value in line
     * @Column
     *        Name is specified because the name in the table uses underscore, we use camel case for the variables as best practice
     *        This value should also be unique for this column so we specify that as well
     *        Finally the field should not be null, this is taken care of by generated value but we specify so the developer is aware
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id",unique = true, nullable = false)
    private Long productId;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String name;

    // @CreationTimestamp makes sure to persist(sets the value to) the current timestamp when a new object is being created
    @CreationTimestamp
    @Column(name = "created_ts")
    private Timestamp createdTS;

    // @UpdateTimestamp makes sure to persist(sets the value to) the current timestamp when an object is being updated
    @UpdateTimestamp
    @Column(name = "updated_ts")
    private Timestamp updatedTS;

    @Column
    private String category;

    @Column
    private Blob image;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

   
    
    
}
