package com.xtinacodes.tv.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.xtinacodes.tv.models.Show;
import java.util.*;

@Repository
public interface ShowRepo extends CrudRepository<Show, Integer>{
	List<Show> findAll();
}
