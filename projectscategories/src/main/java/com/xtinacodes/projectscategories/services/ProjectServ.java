package com.xtinacodes.projectscategories.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.util.*;

import com.xtinacodes.projectscategories.models.*;
import com.xtinacodes.projectscategories.repositories.ProjectRepo;

@Service
public class ProjectServ {
    
    @Autowired
    private ProjectRepo repo;

    // SELECT ALL
    public List<Project> selectAll(){
        return repo.findAll();
    }
    // SELECT ONE
    public Project selectOne(int id){
        return repo.findById(id).orElse(null);
    }
    // SAVE / UPDATE
    public Project save(Project e){
        e.getInfo();
        System.out.println(e.getCategories());
        repo.save(e);
        return e;
    }
    // DELETE
    public void delete(int e){
        repo.deleteById(e);
    }
    // GET UNASSIGNED PRODUCTS
    public List<Project> getUnassigned(Category e){
        return repo.findByCategoriesNotContains(e);
    }


}