/* I AM A DOMAIN MODEL CLASS
 * I AM PART OF THE PERSISTENCE LAYER - > Manage application's data
 * I MODEL A MYSQL TABLE
 * I AM USED AS A REPRESENTATION OF DATA
 * I AM PART OF THE (M) IN MVC
 */
package com.xtinacodes.books.models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
	//id
	//auto-generate
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// size above variable
	@Size(min=5, max=100)
	private String title;
	private int pages;
	//not allow created at with every save
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	// CONSTRUCTOR
	public Book() {
	}
	
	public Book(Map<String, Object> requests) {
		this.title = (@Size(min = 5, max = 100) String) requests.get("title");
		this.pages = (int) requests.get("pages");
	}
	
	// UPDATES
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	// ACCESSORS
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public int getPages() {
		return pages;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void getInfo() {
		System.out.println("********************************");
		System.out.println("************* BOOK *************");
		System.out.println("********************************");
		System.out.println("ID: " + id);
		System.out.println("TITLE: " + title);
		System.out.println("PAGES: " + pages);
		System.out.println("Created At " + createdAt);
		System.out.println(updatedAt);
		System.out.println("********************************" + "\n\n");
	}

	
	// MUTATORS
	public int setID(int e) {
		return this.id = e;
	}
	public String setTitle(Object e) {
		return this.title = (@Size(min = 5, max = 100) String) e;
	}
	public int setPages(Object e) {
		return this.pages = (int) e;
	}
	public Date setCreatedAt(Date e) {
		return this.createdAt = e;
	}
	public Date setUpdatedAt(Date e) {
		return this.updatedAt = e;
	}
}
