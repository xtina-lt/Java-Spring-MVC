/* I AM THE REPOSITORY CLASS
 *  * I AM PART OF THE PERSISTENCE LAYER - > Manage application's data
 *  I AM USED TO: 
 *  I AM PART OF THE (M) IN MVC
 */
package com.xtinacodes.books.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xtinacodes.books.models.Book;
import java.util.*;

@Repository
public interface BookRepo extends CrudRepository<Book, Integer>{
	
	List<Book> findAll();
	List<Book> findByTitleContaining(String e);
	// countBy<Column>Containing, removeBy<Column>
}
