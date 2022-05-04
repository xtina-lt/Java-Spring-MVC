package com.xtinacodes.projectscategories.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.util.*;

import com.xtinacodes.projectscategories.models.Category;
import com.xtinacodes.projectscategories.models.Project;
//import com.xtinacodes.projectscategories.models.Project;
import com.xtinacodes.projectscategories.repositories.CategoryRepo;

@Service
public class CategoryServ {
    
    @Autowired
    private CategoryRepo repo;

    // SELECT ALL
    public List<Category> selectAll(){
        return repo.findAll();
    }
    // SELECT ONE
    public Category selectOne(int id){
        return repo.findById(id).orElse(null);
    }
    // SAVE / UPDATE
    public Category save(Category e){
        return repo.save(e);
    }
    // DELETE
    public void delete(int e){
        repo.deleteById(e);
    }
    // FIND UNASSIGNED
    public List<Category> getUnassigned(Project e){
        return repo.findByProjectsNotContains(e);
    }
}
