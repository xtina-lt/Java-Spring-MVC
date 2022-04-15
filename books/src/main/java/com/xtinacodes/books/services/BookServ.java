/* I AM A SERVICE
 * I AM THE BUSINESS LOGIC OF OUR APPLICATION
 * I WORK ALONGSIDE THE MODEL AND REPO
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
	public Book save(Book e) {
		// both saves and updates
		return repo.save(e);
	}
	
	public Book findBook(int id) {
		Optional<Book> e = repo.findById(id);
		// OPTIONAL MEANS EITHER EXISTS OR NOT
		Book result = (e.isPresent()) ? e.get() : null;
		return result;
	}
}
