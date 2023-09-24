package com.ecomm.Service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import com.ecomm.Dao.RoleDao;
import com.ecomm.Dao.UserDao;
import com.ecomm.Exception.AuthenticationException;
import com.ecomm.Model.User;


/** Marking this as a service for spring application */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired 
    RoleDao roleDao;


    /*
     * Method creates a new user in database if no role given to it will default to general user
     * 
     * @param       Expects a User object that directly maps to row that matches database
     */
    public void createUser(User userDTO){
        if(userDTO.getRoles().isEmpty()){
            userDTO.getRoles().add(roleDao.getRoleByName("General User"));
        }
        userDao.save(userDTO);
    }

    public ArrayList<User> getAllUsers(){
        ArrayList<User> users = userDao.getAll();
        return users;
    }

    public User getUser(Integer id){
        User user = userDao.get(id);

        return user;
    }

    public User getUserWithUsernameOrEmail(String credential) throws BadCredentialsException{
        return userDao.getUserWithUsernameOrEmail(credential);
    }

    public void attemptLogin(Map<String,String> loginRequest){
    }
    
}
