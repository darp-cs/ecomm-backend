package com.ecomm.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.Model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    
    public ArrayList<User> findAll();


}
