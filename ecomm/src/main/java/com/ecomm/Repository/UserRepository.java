package com.ecomm.Repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecomm.Model.User;



@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    
    public ArrayList<User> findAll();

    public Optional<User> findByUsername(String username);

    //@Query annotation allows you to create a sql statement that will be executed
    //question mark(?) is placed as a marker where a dynamic variable will be
    //number after question mark states what parameter will be dynamically used
    //numbers start from left to right starting at 1
    //native query says this query can be used directly in database
    /*
     * Method looks for object based on either email or username allowing multi credential login
     * 
     * @param       Expects credential of either username or email of type string
     * @returns     Returns an optional of type User, this means it may or may not be there, wont be null
     */
    @Query(value = "SELECT * FROM user WHERE username =?1 OR email =?1", nativeQuery = true)
    public Optional<User> findByUsernameOrEmail(String credential);
    // @Query(value = "SELECT * FROM user WHERE username =?1", nativeQuery = true)
    // public Optional<User> findByUsername(String username);


}
