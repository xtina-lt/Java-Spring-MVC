package com.xtinacodes.dojosninjas.models;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")
public class Dojo {
	
	// CLASS VARIABLES
	// id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// name
	
	@NotEmpty
	@Size(min = 3, max = 45, message="Try a little longer..")
	private String name;

	// ONE TO ONE
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="address_id")
    private Address address;
    
    // ONE TO MANY
    @OneToMany(mappedBy="dojo", fetch = FetchType.EAGER)
    private List<Ninja> ninjas;

	
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
	public Dojo() {}
	
	
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
	public Address getAddress() {
		return address;
	}
	public void getInfo() {
		System.out.println("id: " + id);
		System.out.println("name: " + name);
		System.out.println("street: " + address.getStreet());
		System.out.printf("%s , %s\n", address.getCity(), address.getState());
		System.out.printf("Zip: %d\n", address.getZip());
		
	}
	
	// MUTATORS
	public int setId(int e) {
		return this.id = e;
	}
	public String setName(String e) {
		return this.name = e;
	}	

	public Date setCreatedAt(Date e) {
		return this.createdAt = e;
	}
	public Date setUpdatedAt(Date e) {
		return this.updatedAt = e;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
