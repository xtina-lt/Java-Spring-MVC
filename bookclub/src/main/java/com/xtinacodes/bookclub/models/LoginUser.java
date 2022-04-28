package com.xtinacodes.bookclub.models;

import javax.validation.constraints.*;


public class LoginUser {
	
	// EMAIL
	@NotEmpty(message="Let us know how to contact you..")
	@Size(min=2, max=100, message="Try another email")
	private String email;
	
	// PASSWORD
	@NotEmpty(message="Password required yo!")
	@Size(min=8, max=255, message="Try a longer password")
	private String password;
	
	
	// CONSTRUCTORS
	public LoginUser() {}
	
	
	// ACCESSORS
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}


	// MUTATORS
	public String setEmail(String e) {
		return this.email = e;
	}
	public String setPassword(String e) {
		return this.password = e;
	}
	
	
}
