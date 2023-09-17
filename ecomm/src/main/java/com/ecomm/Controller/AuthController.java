package com.ecomm.Controller;


import java.util.HashMap;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.Model.LoginRequest;
import com.ecomm.Model.LoginResponse;
import com.ecomm.Model.User;
import com.ecomm.Security.JwtUtil;
import com.ecomm.Service.UserAuthDetailsService;
import com.ecomm.Service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
	private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    JwtUtil jwtUtil;

    
    private static Logger logger = LoggerFactory.getLogger(AuthController.class);
    
    
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request)  {

        // try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getCredential(), request.getPassword()));
            User user = userService.getUserWithUsernameOrEmail(request.getCredential());
            String token = jwtUtil.createToken(user);
            LoginResponse response = new LoginResponse(token,user);
            return ResponseEntity.ok(response);

        // }catch (BadCredentialsException e){
        //     // ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST,"Invalid username or password");
        //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        // }catch (Exception e){
        //     // ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
        //     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        // }
    }
}
