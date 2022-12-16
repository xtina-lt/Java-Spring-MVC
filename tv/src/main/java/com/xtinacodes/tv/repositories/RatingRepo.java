package com.xtinacodes.tv.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.xtinacodes.tv.models.Rating;
import java.util.*;

@Repository
public interface RatingRepo extends CrudRepository<Rating, Integer>{
	List<Rating> findAll();
}
