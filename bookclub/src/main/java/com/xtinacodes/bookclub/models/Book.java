package com.xtinacodes.bookclub.models;

import java.util.*;


import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="books")
public class Book {
	
	// ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// TITLE
	@NotEmpty(message="What's the best book ever?!")
	@Size(min=2, max=255, message="Try a longer name..")
	private String title;
	
	// DESCRIPTION
	@NotEmpty(message="Why is it the best book ever?!")
	private String description;
	
	// IMG
	@NotEmpty(message="Gimme a link!")
	@NotNull
	@Size(min=10, message="Gimme a link!")
	private String img;
	
	// AUTHOR
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="author_id")
    private Author author;

	
	// USER
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
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
	public Book() {}
	public Book(String t, String d, String img, Author a, User u) {
		this.title = t;
		this.description = d;
		this.img = img;
		this.author = a;
		this.user = u;
	}


	
	// ACCESSORS
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getImg() {
		return img;
	}
	public Author getAuthor() {
		return author;
	}
	public User getUser() {
		return user;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void getInfo() {
		System.out.println("Title: " + title);
		System.out.println("Description: " + description);
		System.out.printf("Author: %s, %s.\n", author.getLast(), author.getFirst());
		System.out.printf("User: %s, %s.\n", user.getLast(), user.getFirst());
	}

	
	// MUTATORS
	public int setId(int e) {
		return this.id = e;
	}
	public String setTitle(String e) {
		if (e.length() > 0){
			StringBuilder sb = new StringBuilder(e);
			sb.setCharAt(0, Character.toTitleCase(sb.charAt(0)));
			return this.title=sb.toString();
		} else {
			return this.title="";
		}

	}
	
	public String setDescription(String e) {
		return this.description = e;
	}
	public String setImg(String e) {
		return this.img = e;
	}
	public Author setAuthor(Author e) {
		return this.author = e;
	}
	public User setUser(User e) {
		return this.user = e;
	}
	public Date setCreatedAt() {
		return this.createdAt;
	}
	public Date setUpdatedAt() {
		return this.updatedAt;
	}


	
	
}
