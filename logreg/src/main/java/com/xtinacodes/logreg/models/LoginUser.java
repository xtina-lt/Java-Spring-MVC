package com.xtinacodes.logreg.models;
import javax.validation.constraints.*;

public class LoginUser {
    // EMAIL
    @NotEmpty(message="Let us know how to contact you..")
    @Size(min=2, max=100)
    private String email;
    // PASSWORD
    @NotEmpty(message="Password required yo!")
    @Size(min=8, max=255)
    private String password;

    // CONSTRUCTORS
    public LoginUser(){}

    // GETTERS
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }


    // SETTERS

    public String setEmail(String e){
        return this.email = e;
    }
    public String setPassword(String e){
        return this.password=e;
    }

}
