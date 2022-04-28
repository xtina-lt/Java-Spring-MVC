package com.xtinacodes.bookclub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import com.xtinacodes.bookclub.models.Book;
import com.xtinacodes.bookclub.repositories.BookRepo;
import java.util.*;

@Service
public class BookServ {
	
	@Autowired
	private BookRepo repo;
	
	// SELECT ALL
	public List<Book> selectAll(){
		return repo.findAll();
	}
	
	// SELECT ONE
	public Book selectOne(int id) {
		return repo.findById(id).orElse(null);
	}
	
	// SAVE / UPDATE
	public Book save(Book e) {
		return repo.save(e);
	}
	
	// DELETE
	public void delete(int e) {
		repo.deleteById(e);
	}
	
}
