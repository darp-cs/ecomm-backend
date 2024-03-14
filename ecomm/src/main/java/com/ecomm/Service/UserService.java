package com.ecomm.Service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.Model.User;
import com.ecomm.Repository.RoleRepository;
import com.ecomm.Repository.UserRepository;


/** Marking this as a service for spring application */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    /*
     * Method creates a new user in database if no role given to it will default to general user
     * 
     * @param       Expects a User object that directly maps to row that matches database
     */
    public void createUser(User userDTO){
        if(userDTO.getRoles().isEmpty()){
            userDTO.getRoles().add(roleRepository.findByName("General User"));
            // roleDao.getRoleByName("General User")
        }
        userRepository.save(userDTO);
    }

    public ArrayList<User> getAllUsers(){
        ArrayList<User> users = userRepository.findAll();
        return users;
    }

    public User getUser(Long id){
        User user = userRepository.findByUserId(id);

        return user;
    }

    public User getUserWithUsernameOrEmail(String credential){
        return userRepository.findByUsernameOrEmail(credential).get();
    }

    public void attemptLogin(Map<String,String> loginRequest){
    }
    
}
