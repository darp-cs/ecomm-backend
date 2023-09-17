package com.ecomm.Model;

import java.util.Set;
import java.util.stream.Collectors;

public class LoginResponse {
    
    private String authToken;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Set<String> roles;
    
    //Constructor requiring all default variables to set its own variables
    public LoginResponse(String authToken, String username, String email, String firstName,
            String lastName, Set<String> roles) {
        this.authToken = authToken;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }

    //Overloading constructor above to instead require only an auth token and user object
    //Overloading is a way to have several methods with the same name but different variables as parameter
    public LoginResponse(String authToken, User user){
        this.authToken = authToken;
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.firstName = user.getFirst_name();
        this.lastName = user.getLast_name();
        this.roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toSet());

    }
    public String getAuthToken() {
        return authToken;
    }
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getlastName() {
        return lastName;
    }
    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
    public Set<String> getRoles() {
        return roles;
    }
    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
