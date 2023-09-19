package com.ecomm.Exception;

//Here we extend runtime exception because this will be an exception found during runtime only otherwise known as an unchecked extension
//These do not have to be declared as throws in method signature
//These are used when user can not recover from the exception and there is a code issue
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String errorMessage, Throwable err){
        super(errorMessage,err);
    }
    
}
