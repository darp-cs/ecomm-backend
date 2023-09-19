package com.ecomm.Controller;



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
import com.ecomm.Service.UserService;

//Rest controller annotation marks class as a Rest controller that will handle apis
//Request Mapping requires apis to be preceded with /auth (eg. /auth/login)
@RestController
@RequestMapping("/auth")
public class AuthController {

    //Autowired tells spring application this variable requires dependency injection
    @Autowired
	private AuthenticationManager authenticationManager;

    //Autowired tells spring application this variable requires dependency injection
    @Autowired
    private UserService userService;

    //Autowired tells spring application this variable requires dependency injection
    @Autowired
    JwtUtil jwtUtil;

    //Loggers are a form of logging that is useful for logging to an application or in your local debugger
    private static Logger logger = LoggerFactory.getLogger(AuthController.class);
    
    /*
     * Receives a login request authenticates the credentials provided, if authenticated, 
     * a bearer token is created otherwise an exception
     * 
     * 
     * @param       Expected parameter is a json that maps to a LoginRequest object
     * @return      Returns either a LoginResponse object or an Exception
     */
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestBody LoginRequest request)  {

        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getCredential(), request.getPassword()));
            User user = userService.getUserWithUsernameOrEmail(request.getCredential());
            String token = jwtUtil.createToken(user);
            LoginResponse response = new LoginResponse(token,user);
            return ResponseEntity.ok(response);

        }catch (BadCredentialsException e){
            // ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST,"Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }catch (Exception e){
            // ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }
    }
}
