package com.xtinacodes.tv.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.xtinacodes.tv.models.User;
import java.util.*;

@Repository
public interface UserRepo extends CrudRepository<User, Integer>{
	List<User> findAll();

	Optional<User> findByEmail(String e);
}
