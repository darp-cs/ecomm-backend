package com.ecomm.Service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.Dao.RoleDao;
import com.ecomm.Dao.UserDao;
import com.ecomm.Model.User;


/** Marking this as a service for spring application */
@Service
public class UserService {

    /** Autowired annotation injects dependencies(Resources required)*/
    @Autowired
    UserDao userDao = new UserDao();

    @Autowired 
    RoleDao roleDao = new RoleDao();


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

    public void attemptLogin(Map<String,String> loginRequest){
    }
    
}
