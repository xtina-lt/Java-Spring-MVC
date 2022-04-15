package com.xtinacodes.books.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xtinacodes.books.models.Book;
import java.util.*;

@Repository
// 1 ) annotate
public interface BookRepo extends CrudRepository<Book, Integer>{
	// 2) extend CRUD Repo: does all CRUD queries
	// 3) < Model, Primary Key Type( ID ) >
	List<Book> findAll();
	// 4) findAll() see JPA
	List<Book> findByTitleContaining(String e);
	Book findById(int e);
	// 5 ) WHERE
	// countBy<Column>Containing, removeBy<Column>
}
