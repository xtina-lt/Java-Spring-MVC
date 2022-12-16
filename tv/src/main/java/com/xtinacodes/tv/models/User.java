package com.xtinacodes.tv.models;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="users")
public class User {
	
	// ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// NAME
	@NotEmpty(message="Let us know who you are..")
	@Size(min=2, max=60)
	private String name;
	// EMAIL
	@NotEmpty(message="Let us know how to contact you..")
	@Size(min=2, max=100)
	@Email(message="Let's try a valid email :) ")
	private String email;
	// confirm
	@Transient
	@NotEmpty(message="Check yourself before you wreck yourself!")
	@Size(min=2, max=100)
	@Email(message="Let's try a valid email :) ")
	private String confirmE;
	// PASSWORD
	@NotEmpty(message="Password required yo!")
	@Size(min=8, max=255)
	private String password;
	// confirm
	@Transient
	@NotEmpty(message="Check yourself before you wreck yourself!")
	@Size(min=8, max=255)
	private String confirmP;
	// shows
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Show> shows;
	// ratings
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Rating> Ratings;
	// CRERATED AT
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
	// UPDATED AT
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
	// CONSTRUCTORS
	public User() {}

	
	// ACCESSORS
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getConfirmE() {
		return confirmE;
	}
	public String getPassword() {
		return password;
	}
	public String getConfirmP() {
		return confirmP;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void getInfo() {
		System.out.printf("Name: %s, %s\n", name);
		System.out.println("Email: " + email);
	}

	
	// MUTATORS
	public int setId(int e) {
		return this.id = e;
	}
	public String setName(String e) {
		String result = (e.isEmpty())? "" : e.substring(0,1).toUpperCase() + e.substring(1);
		return this.name = result;
	}
	public String setEmail(String e) {
		return this.email = e;
	}
	public String setConfirmE(String e) {
		return this.confirmE = e;
	}
	public String setPassword(String e) {
		return this.password = e;
	}
	public String setConfirmP(String e) {
		return this.confirmP = e;
	}
	public Date setCreatedAt() {
		return this.createdAt;
	}
	public Date setUpdatedAt() {
		return this.updatedAt;
	}


	
	
}
