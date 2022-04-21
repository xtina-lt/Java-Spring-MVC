package com.xtinacodes.saveTravels.models;


import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="trips")
public class Trip {
	
	// CLASS VARIABLES
	// id	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// name	
	@Size(min = 3, max = 45, message="Between 3 and 45 characters.")
	private String name;
	// amount
	@DecimalMin(value="1.0", message="At least one dollar")
	private double amount;
	// img
	@Size(min = 15, max = 255, message="Between 15-255 characters.")
	private String img;
	// created at
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date created_at;
	// updated at
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updated_at;
	// Right before object is created save date
	@PrePersist
	public void onCreate() {
		this.created_at = new Date();
	}
	// On every update save date object is being updated
	@PreUpdate
	public void onUpdate() {
		this.updated_at = new Date();
	}
	
	// CONSTRUCTORS
	public Trip() {
	}
	public Trip(String n, double a, String i) {
		this.name = n;
		this.amount = a;
		this.img = i;
	}
	
	// ACCESSORS
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getAmount() {
		return Math.round(amount*100.00)/100.00;
	}
	public String getImg() {
		return img;
	}
	public Date getCreatedAt() {
		return created_at;
	}
	public Date getUpdatedAt() {
		return updated_at;
	}
	public void getInfo() {
		System.out.println("Name: " + name);
		System.out.println("Amount: " + amount);
		System.out.println("Created At: " + created_at);
		System.out.println("Updated At: " + updated_at);
	}
	
	// MUTATORS
	public void setName(String e) {
		this.name = e;
	}
	public void setAmount(double e) {
		this.amount = e;
	}
	public void setImg(String e) {
		this.img = e;
	}
	public void setCreatedAt() {
		this.created_at = new Date();
	}
	public void setUpdatedAt() {
		this.updated_at = new Date();
	}


}
