package com.xtinacodes.logreg.models;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="users")
public class User {
	
	// ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// FIRST NAME
	@NotEmpty(message="Let us know who you are..")
	@Size(min=2, max=45)
	private String first;
	
	// LAST NAME
	@NotEmpty(message="Let us know who you are..")
	@Size(min=2, max=45)
	private String last;
	
	// EMAIL
	@NotEmpty(message="Let us know how to contact you..")
	@Size(min=2, max=100)
	private String email;
	
	@Transient
	@NotEmpty(message="Check yourself before you wreck yourself!")
	@Size(min=2, max=100)
	private String confirmE;
	
	// PASSWORD
	@NotEmpty(message="Password required yo!")
	@Size(min=8, max=255)
	private String password;
	
	@Transient
	@NotEmpty(message="Check yourself before you wreck yourself!")
	@Size(min=8, max=255)
	private String confirmP;
	
 
	
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
	public String getFirst() {
		return first;
	}
	public String getLast() {
		return last;
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
		System.out.printf("Name: %s, %s\n", last, first);
		System.out.println("Email: " + email);
	}

	
	// MUTATORS
	public int setId(int e) {
		return this.id = e;
	}
	public String setFirst(String e) {
		String result = (e.isEmpty())? "" : e.substring(0,1).toUpperCase() + e.substring(1);
		return this.first = result;
	}
	public String setLast(String e) {
		String result = (e.isEmpty())? "" : e.substring(0,1).toUpperCase() + e.substring(1);
		return this.last = result;
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
