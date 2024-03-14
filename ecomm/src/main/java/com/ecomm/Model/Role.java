package com.ecomm.Model;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//By implementing Serializable we can represent an objects state as a byte stream
public class Role implements Serializable{


    /*@Id Specifies this is the primary key for this table
     * @GeneratedValue Specifies that this value will be auto generated if not provided as the next value in line
     * @Column
     *        Name is specified because the name in the table uses underscore, we use camel case for the variables as best practice
     *        This value should also be unique for this column so we specify that as well
     *        Finally the field should not be null, this is taken care of by generated value but we specify so the developer is aware
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id", nullable=false, unique=true)
    private Long roleId;

    @Column(nullable=false, unique=true)
    private String name;

    @Column(nullable=false)
    private String  description;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
