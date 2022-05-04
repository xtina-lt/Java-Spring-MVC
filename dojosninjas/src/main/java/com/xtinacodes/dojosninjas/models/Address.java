package com.xtinacodes.dojosninjas.models;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="addresses")
public class Address {
	
	// CLASS VARIABLES
	// id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// street
	@Size(min = 9, max = 255, message="Try a longer street..")
	private String street;
	// city
	@Size(min = 3, max = 60, message="City should be between 3 and 60 characters.")
	private String city;
	// state
	@Size(min = 2, max = 2, message="Try an abbreviation")
	private String state;
	// zip
	@Min(value=501, message="try longer zip")
	private int zip;
	
	
	// ONE TO ONE
	// dojo
	@OneToOne(mappedBy="address", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Dojo dojo;
	
	// ONE TO ONE
	// ninja
	@OneToOne(mappedBy="address", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Ninja ninja;
	
	// creatd_at
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
	public Address() {}
	public Address(int i, String s, String c, String st, int z ) {
		this.id=i;
		this.street = s;
		this.city = c;
		this.state = st;
		this.zip = z;
	}
//	public Address(Address e) {
//		this.id = e.getId();
//		this.street = e.getStreet();
//		this.city = e.getCity();
//		this.state = e.getState();
//		this.zip = e.getZip();
//	}
	
	
	// ACCESSORS
	public int getId() {
		return id;
	}
	public String getStreet() {
		return street;
	}	
	public String getCity() {
		return city;
	}	
	public String getState() {
		return state;
	}
	public int getZip() {
		return zip;
	}	
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void getInfo() {
		System.out.println("id: " + id);
		System.out.printf("%s \n %s, %s, %d", street, city, state, zip);
	}
	
	// MUTATORS
	public int setId(int e) {
		return this.id = e;
	}
	public String setStreet(String e) {
		return this.street = e;
	}	
	public String setCity(String e) {
		return this.city = e;
	}
	
	public String setState(String e) {
		return this.state = e;
	}
	public int setZip(int e) {
		return this.zip = e;
	}	
	public Date setCreatedAt(Date e) {
		return this.createdAt = e;
	}
	public Date setUpdatedAt(Date e) {
		return this.updatedAt = e;
	}
}
