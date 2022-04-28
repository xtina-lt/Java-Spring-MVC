package com.xtinacodes.bookclub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import com.xtinacodes.bookclub.models.Author;
import com.xtinacodes.bookclub.repositories.AuthorRepo;

import java.util.*;

@Service
public class AuthorServ {
	
	@Autowired
	private AuthorRepo repo;
	
	// SELECT ALL
	public List<Author> selectAll(){
		return repo.findAll();
	}
	
	// SELECT ONE
	public Author selectOne(int id) {
		return repo.findById(id).orElse(null);
	}
	
	// SAVE / UPDATE
	public Author save(Author e) {
		return repo.save(e);
	}
	
	// DELETE
	public void delete(int e) {
		repo.deleteById(e);
	}

}
