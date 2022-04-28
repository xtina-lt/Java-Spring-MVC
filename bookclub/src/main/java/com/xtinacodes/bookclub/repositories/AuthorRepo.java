package com.xtinacodes.bookclub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.xtinacodes.bookclub.models.Author;
import java.util.*;

@Repository
public interface AuthorRepo extends CrudRepository<Author, Integer>{
	
	List<Author> findAll();
	
}
