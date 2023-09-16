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

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService = new UserService();

    @PostMapping("/register")
    public void createUser(@RequestBody User userDTO) {
       userService.createUser(userDTO);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<ArrayList<User>> getAllUsers() {
        ArrayList<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@RequestParam("id") Integer id){
        
    }

    @GetMapping("/getUser")
    public ResponseEntity<User> getUser(@RequestParam("id") Integer id){
        return ResponseEntity.ok(userService.getUser(id));
    }
    
}
