package com.xtinacodes.babynames.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.xtinacodes.babynames.models.Name;

import java.util.*;

@Repository
public interface NameRepo extends CrudRepository<Name, Integer>{
	List<Name> findAll();
	Optional<Name> findByName(String e);
}
