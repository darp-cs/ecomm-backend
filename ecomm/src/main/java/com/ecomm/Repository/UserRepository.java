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

    @Query(value = "SELECT u FROM User u Where u.user_name = 1", nativeQuery = true)
    public Optional<User> findByUser_name(String username);

    // public User findByUser_nameAndPassword();


}
