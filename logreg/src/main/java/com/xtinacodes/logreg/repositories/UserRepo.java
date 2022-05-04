package com.xtinacodes.logreg.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.xtinacodes.logreg.models.User;
import java.util.*;

@Repository
public interface UserRepo extends CrudRepository<User, Integer>{
	List<User> findAll();

	Optional<User> findByEmail(String e);
}
