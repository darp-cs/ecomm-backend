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

    @Query(value = "SELECT * FROM user WHERE username =?1 OR email =?1", nativeQuery = true)
    public Optional<User> findByUsernameOrEmail(String username);
    // @Query(value = "SELECT * FROM user WHERE username =?1", nativeQuery = true)
    // public Optional<User> findByUsername(String username);


}
