
package com.xtinacodes.dojosninjas.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.*;
import java.util.*;
import com.xtinacodes.dojosninjas.models.Dojo;

@Repository
public interface DojoRepo extends CrudRepository<Dojo, Integer>{
    
    List<Dojo> findAll();
   
}

