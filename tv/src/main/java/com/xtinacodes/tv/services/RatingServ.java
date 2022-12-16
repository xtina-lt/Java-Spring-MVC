package com.xtinacodes.tv.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.util.*;
import com.xtinacodes.tv.models.Rating;
import com.xtinacodes.tv.repositories.*;

@Service
public class RatingServ {
    
    @Autowired
    private RatingRepo repo;

    // SELECT ALL
    public List<Rating> selectAll(){
        return repo.findAll();
    }
    // SELECT ONE
    public Rating selectOne(int e){
        return repo.findById(e).orElse(null);
    }
    // EDIT CREATE
    public Rating save(Rating e){
        return repo.save(e);
    }
    // DELETE
    public void delete(int e){
        repo.deleteById(e);
    }

}
