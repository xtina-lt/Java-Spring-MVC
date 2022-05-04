/* I AM A SERVICE CLASS
 * I AM THE SERVICE LAYER
 * I AM USED AS: BUSINESS LOGIC OF OUR APPLICATION
 * I AM PART OF THE (M) IN MVC
 */
package com.xtinacodes.books.services;

import org.springframework.stereotype.Service;

import java.util.*;
import com.xtinacodes.books.repositories.BookRepo;
import com.xtinacodes.books.models.*;

@Service
// 1) ANNOTATE CLASS
public class BookServ {
	private final BookRepo repo;
	// 2) initialize a book repo instance
	// 2) this will inherit any methods like findall
	
	// 3) CONSTRUCTOR
	public BookServ(BookRepo e) {
		this.repo = e;
	}
	
	//ACCESSORS
	public List<Book> allBooks(){
		return repo.findAll();
	}
	public List<Book> findBy(String e){
		return repo.findByTitleContaining(e);
	}

	public Book selectOne(int id) {
		return repo.findById(id).orElse(null);
	}
	
	// MUTATORS
	public Book save(Book e) {
		// both saves and updates
		return repo.save(e);
	}
	
}
