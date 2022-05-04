package com.xtinacodes.saveTravels.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import com.xtinacodes.saveTravels.models.Trip;
import com.xtinacodes.saveTravels.repositories.TripRepo;

import java.util.*;

@Service
public class TripServ {
	
	@Autowired
	private TripRepo repo;
	
	public List<Trip> selectAll(){
		return repo.findAll();
	}
	
	public Trip selectOne(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public Trip save(Trip e) {
		return repo.save(e);
	}
	
	public void delete(int e) {
		repo.deleteById(e);
	}
}
