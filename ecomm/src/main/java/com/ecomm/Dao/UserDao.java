package com.ecomm.Dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomm.Model.User;
import com.ecomm.Repository.UserRepository;

@Component
public class UserDao implements Dao<User>{

    @Autowired
    UserRepository userRepository;

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

    
}
