package com.xtinacodes.saveTravels.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.*;

import java.util.*;
import com.xtinacodes.saveTravels.models.Trip;

@Repository
public interface TripRepo extends CrudRepository<Trip, Integer>{
	
	List<Trip> findAll();
	
	Trip findById(int e);
	
	Trip findByName(String e);
	

}
