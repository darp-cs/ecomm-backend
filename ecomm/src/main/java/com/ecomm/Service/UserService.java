package com.ecomm.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ecomm.Dao.UserDao;
import com.ecomm.Model.User;


/** Marking this as a service for spring application */
@Service
public class UserService {

    /** Autowired annotation injects dependencies(Resources required)*/
    @Autowired
    UserDao userDao = new UserDao();


    public void createUser(User userDTO){
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
    
}
