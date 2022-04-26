
package com.xtinacodes.dojosninjas.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.*;
import java.util.*;
import com.xtinacodes.dojosninjas.models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Integer>{
    
    List<Ninja> findAll();
   
}

