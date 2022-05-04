
package com.xtinacodes.dojosninjas.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.*;
import java.util.*;
import com.xtinacodes.dojosninjas.models.Address;

@Repository
public interface AddressRepo extends CrudRepository<Address, Integer>{
    
    List<Address> findAll();
    
    
}

