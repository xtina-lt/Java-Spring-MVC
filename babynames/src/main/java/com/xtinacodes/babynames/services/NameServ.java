package com.xtinacodes.babynames.services;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.*;
import org.springframework.validation.BindingResult;
import java.util.*;
import com.xtinacodes.babynames.models.Name;
import com.xtinacodes.babynames.repositories.*;

@Service
public class NameServ {
    
    @Autowired
    private NameRepo repo;

    // SELECT ALL
    public List<Name> selectAll(){
        return repo.findAll();
    }
    // SELECT ONE
    public Name selectOne(int e){
        return repo.findById(e).orElse(null);
    }
    //CREATE
    public Name save(Name e, BindingResult result){
    	Name n = repo.findByName(e.getName()).orElse(null);
    	if (n!=null) result.rejectValue("name", "Unique", "Let's try a different name:)");
    	if (result.hasErrors()) return null;
    	repo.save(e);
    	return e;
    }
    // EDIT
    public Name esave(Name e){
    	Name n = repo.findByName(e.getName()).orElse(null);
    	e.setLikes(n.getLikes());
    	System.out.println(e.getLikes());
        return repo.save(e);
    }
    // DELETE
    public void delete(int e){
        repo.deleteById(e);
    }

}
