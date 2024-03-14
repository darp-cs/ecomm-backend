package com.ecomm.Controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.Model.User;
import com.ecomm.Service.UserService;

//Rest controller annotation marks class as a Rest controller that will handle apis
//Request Mapping requires apis to be preceded with /users (eg. /users/register)
@RestController
@RequestMapping("/users")
public class UserController {

    //Autowired tells spring application this variable requires dependency injection
    @Autowired
    UserService userService = new UserService();

     /*
     * Receives a user object then creates a new record in database    
     * 
     * @param       Expected parameter is a json that maps to a User object
     */
    @PostMapping("/register")
    public void createUser(@RequestBody User userDTO) {
       userService.createUser(userDTO);
    }

    /*
     * Method used to get all users from database  
     * 
     * @return returns all users in databsae
     */
    @GetMapping("/getAllUsers")
    public ResponseEntity<ArrayList<User>> getAllUsers() {
        ArrayList<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

     /*
     * Delete user by id
     * 
     * @param       Expected parameter is the id for user to delete
     */
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@RequestParam("id") Long id){
        
    }

    /*
     * Method used to find a user by id 
     * 
     * @param       Expected parameter is the id of user to get information for
     * @return      Returns user object
     */
    @GetMapping("/getUser")
    public ResponseEntity<User> getUser(@RequestParam("id") Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }
    
}
