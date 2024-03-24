package com.ecomm.Model;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;



@Entity
//By implementing Serializable we can represent an objects state as a byte stream
public class User implements Serializable{


    /*@Id Specifies this is the primary key for this table
     * @GeneratedValue Specifies that this value will be auto generated if not provided as the next value in line
     * @Column
     *        Name is specified because the name in the table uses underscore, we use camel case for the variables as best practice
     *        This value should also be unique for this column so we specify that as well
     *        Finally the field should not be null, this is taken care of by generated value but we specify so the developer is aware
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", nullable = false,unique = true)
    private Long userId;

    // @CreationTimestamp makes sure to persist(sets the value to) the current timestamp when a new object is being created
    @CreationTimestamp
    @Column(name="created_ts")
    private Timestamp createdTS;

    // @UpdateTimestamp makes sure to persist(sets the value to) the current timestamp when an object is being updated
    @UpdateTimestamp
    @Column(name="updated_ts")
    private Timestamp updatedTS;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    

    /*
     * @ManyToMany specifies that many users maps to many roles ie. One user can map to many roles(more than one) and there is many users
     *                                                              One role can map to many users(more than one) and there is many roles
     *             Fetch type can be either lazy or eager, lazy will not load this item into memory from the start, it will only load it if accessed (Best practice way, can cause issues later if not controlled correctly)
     *                                                     eager will load the object into memory, this is the easier way but not the best practice as it can load too much into memory at once
     *                                                     both can cause the app the be slow for different reasons
     *              cascade specifies that any operation done to a user such as PERSIST, REMOVE, REFRESH, MERGE, DETACH will propogate to the records associated
     *              ie. if you delete this user, the associated record will be deleted in the user_role table
     * @JoinTable    name specifies the linking table used to create a relationship between user and role
     *               join columns tells the table what columns to use to create this object
     *               join columns specifies what primary key from user to user, inverse columns specifies the column to use from the other table used to create this linking table
     * 
     * NOTE: roles is a Set because we are expecting unique roles at all times
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(
            name="user_role",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="role_id")})
    private Set<Role> roles = new HashSet<>();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

   

    
}
