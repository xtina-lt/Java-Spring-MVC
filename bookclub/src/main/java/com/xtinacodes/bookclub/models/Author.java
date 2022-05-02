package com.xtinacodes.bookclub.models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;





@Entity
@Table(name="authors")
public class Author {
	
	// ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// FIRST
	@NotEmpty(message="First name please")
	@Size(min=2, max=45, message="First name between 2 and 45 characters please..")
	private String first;
	
	// LAST
	@NotEmpty(message="First name please")
	@Size(min=2, max=45, message="First name between 2 and 45 characters please..")
	private String last;
	
	// BOOK
    // ONE TO MANY
    @OneToMany(mappedBy="author", fetch = FetchType.LAZY)
    private List<Book> books;
	
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
	public Author() {}
	public Author(String f, String l) {
		this.first = f;
		this.last = l;
	}
	

	
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
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void getInfo() {
		System.out.println("First: " + first);
		System.out.println("Last: " + last);
	}

	
	// MUTATORS
	public int setId(int e) {
		return this.id = e;
	}
	public String setFirst(String e) {
		String result = (e != null)? e.substring(0,1).toUpperCase() + e.substring(1) : "null";
		return this.first = result;
	}
	public String setLast(String e) {
		String result = (e != null)? e.substring(0,1).toUpperCase() + e.substring(1) : "null";
		return this.last = result;
	}
	public Date setCreatedAt() {
		return this.createdAt;
	}
	public Date setUpdatedAt() {
		return this.updatedAt;
	}


	
	
}
