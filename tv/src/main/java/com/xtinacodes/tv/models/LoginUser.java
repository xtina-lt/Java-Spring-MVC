package com.xtinacodes.tv.models;
import javax.validation.constraints.*;

public class LoginUser {
    // EMAIL
    @NotEmpty(message="Let us know how to contact you..")
    @Size(min=2, max=100)
    @Email(message="Let's try a valid email :) ")
    private String email;
    // PASSWORD
    @NotEmpty(message="Password required yo!")
    @Size(min=8, max=255)
    private String password;

    // // CONSTRUCTORS
    // // only need empty constructor if you have a paramatized constructor
    // // java auto includes empty constructor
    // public LoginUser(){}

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
