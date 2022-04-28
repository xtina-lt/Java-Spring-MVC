package com.xtinacodes.bookclub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xtinacodes.bookclub.models.Book;
import java.util.*;

@Repository
public interface BookRepo extends CrudRepository<Book, Integer>{
	
	List<Book> findAll();
	
}
