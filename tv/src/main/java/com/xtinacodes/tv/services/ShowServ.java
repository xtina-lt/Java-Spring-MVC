package com.xtinacodes.tv.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.util.*;
import com.xtinacodes.tv.models.Show;
import com.xtinacodes.tv.repositories.*;

@Service
public class ShowServ {
    
    @Autowired
    private ShowRepo repo;

    // SELECT ALL
    public List<Show> selectAll(){
        return repo.findAll();
    }
    // SELECT ONE
    public Show selectOne(int e){
        return repo.findById(e).orElse(null);
    }
    // EDIT CREATE
    public Show save(Show e){
        return repo.save(e);
    }
    // DELETE
    public void delete(int e){
        repo.deleteById(e);
    }

}
