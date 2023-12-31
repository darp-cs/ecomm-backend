package com.ecomm.Dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomm.Model.User;
import com.ecomm.Repository.UserRepository;

//Component annotation lets springboot know to keep track and that its a been that can be autowired
//Implements keyword makes a promise that a class will implement all methods in class its implementing
@Component
public class UserDao implements Dao<User>{

    @Autowired
    UserRepository userRepository;

    //Overriding is required here since Roledao promised to implement all methods in Dao
    @Override
    public User get(int id) {
        return userRepository.findById(id).orElse(null);   
    }


    @Override
    public ArrayList<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User t) {
        userRepository.save(t);
    }


    @Override
    public void delete(User t) {
        userRepository.delete(t);
    }

    /*
     * Method used to find role object by name
     * 
     * @param       Expected parameter is either the username or email for a user to search by
     * @return      returns a user object
     */
    public User getUserWithUsernameOrEmail(String credential){
        return userRepository.findByUsernameOrEmail(credential).orElseThrow();
    }

    
}
