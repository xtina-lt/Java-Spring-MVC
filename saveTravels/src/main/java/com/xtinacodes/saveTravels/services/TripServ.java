package com.xtinacodes.saveTravels.services;

import org.springframework.stereotype.*;

import com.xtinacodes.saveTravels.models.Trip;
import com.xtinacodes.saveTravels.repositories.TripRepo;

import java.util.*;

@Service
public class TripServ {
	
	private final TripRepo ts;
	
	public TripServ(TripRepo e) {
		this.ts = e;
	}
	
	public List<Trip> selectAll(){
		return ts.findAll();
	}
	
	public Trip selectOne(int e) {
//		System.out.println("******");
//		Trip result = ts.findById(e);
//		System.out.println(result);
//		String y = (result == null) ? "null" : "notnull";
//		System.out.println(y);
//		return result;
		Optional<Trip> o = Optional.of(ts.findById(e));
		Trip result = (o.isPresent()) ? o.get() : null;
		return result;
	}
	
	public Trip create(Trip e) {
		return ts.save(e);
	}
	
	public void udpate(int id, String n, Double a, String i) {
		Trip e = ts.findById(id);
		e.setName(n);
		e.setAmount(a);
		e.setUpdatedAt();
		e.setImg(i);
		ts.save(e);
	}
	public void delete(int e) {
		ts.deleteById(e);
	}
}
