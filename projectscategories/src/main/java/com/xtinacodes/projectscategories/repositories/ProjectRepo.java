package com.xtinacodes.projectscategories.repositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

import com.xtinacodes.projectscategories.models.Category;
import com.xtinacodes.projectscategories.models.Project;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Integer>{
    List<Project> findAll();
	List<Project> findByCategoriesNotContains(Category e);
}
