package com.xtinacodes.projectscategories.repositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.*;
import com.xtinacodes.projectscategories.models.*;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer>{
    List<Category> findAll();
    List<Category> findByProjectsNotContains(Project e);
}
