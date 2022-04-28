package com.xtinacodes.dojosninjas.models;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninja {
	
	// CLASS VARIABLES
	// id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// name
	@Size(min = 3, max = 45, message="Try a little longer..")
	private String name;

	// MANY TO ONE
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
    
	// ONE TO ONE
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="address_id")
    private Address address;

	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	// updated_at
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	// date methods
	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}


	
	// CONSTRUCTORS
	public Ninja() {}
	public Ninja(String n, Dojo d, Address a) {
		this.name = n;
		this.dojo = d;
		this.address = a;
	}
	
	// ACCESSORS
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}	

	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public Dojo getDojo() {
		return dojo;
	}
	public Address getAddress() {
		return address;
	}
	public void getInfo() {
		System.out.println("id: " + id);
		System.out.println("name: " + name);
		System.out.println("dojo: " + dojo.getName());
		address.getInfo();
	}
	
	// MUTATORS
	public int setId(int e) {
		return this.id = e;
	}
	public String setName(String e) {
		return this.name = e;
	}	
	public Dojo setDojo(Dojo e) {
		return this.dojo = e;
	}
	public Address setAddress(Address e) {
		return this.address = e;
	}
	public Date setCreatedAt(Date e) {
		return this.createdAt = e;
	}
	public Date setUpdatedAt(Date e) {
		return this.updatedAt = e;
	}
}
