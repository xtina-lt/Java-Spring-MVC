package com.xtinacodes.dojosninjas.services;
import org.springframework.stereotype.*;
import org.springframework.validation.BindingResult;

import com.xtinacodes.dojosninjas.models.Address;
import com.xtinacodes.dojosninjas.repositories.AddressRepo;
import java.util.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@Service
public class AddressServ {
    
    private final AddressRepo s;
    
    public AddressServ(AddressRepo e) {
        this.s = e;
    }
    
    public List<Address> selectAll(){
        return s.findAll();
    }
    
    public Address selectOne(int e) {
        return s.findById(e).orElse(null);
    }
    
    public Address save(Address e) {
        return s.save(e);
    }
    
    public Address update(Address e, BindingResult result) {
		try {
			System.out.println("x");
			return s.save(e);
	      } catch (ConstraintViolationException ahh){
	    	  System.out.println("caught address");
			for (ConstraintViolation<?> i : ahh.getConstraintViolations()) {
			result.rejectValue(String.format("address.%s", i.getPropertyPath().toString()), "error.dojo", i.getMessage());
			}
			return null;
	      }
    }
    
    public void delete(int e) {
        s.deleteById(e);
    }
}

