package com.ecomm.Exception;

//Here we extend Exception because this will be a checked exception that is checked at compile time
//These exceptions must be handled by the programmer
//These can be seen at the end of methods eg. throws AuthenticationException
//These are used when the end user can recover from the issue without code change
public class AuthenticationException extends Exception{
    
    public AuthenticationException(String errorMessage){
        super(errorMessage);
    }
}
