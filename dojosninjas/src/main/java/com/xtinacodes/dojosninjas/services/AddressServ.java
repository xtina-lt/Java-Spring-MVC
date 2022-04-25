
package com.xtinacodes.dojosninjas.services;
import org.springframework.stereotype.*;
import com.xtinacodes.dojosninjas.models.Address;
import com.xtinacodes.dojosninjas.repositories.AddressRepo;
import java.util.*;

@Service
public class AddressServ {
    
    private final AddressRepo s;
    
    public AddressServ(AddressRepo e) {
        this.s = e;
    }
    
    public List<Address> selectAll(){
        return s.findAll();
    }
    
    public Address selectOne(int e) {
        Optional<Address> o = Optional.of(s.findById(e));
        Address result = (o.isPresent()) ? o.get() : null;
        return result;
    }
    
    public Address save(Address e) {
        return s.save(e);
    }
    
    public void delete(int e) {
        s.deleteById(e);
    }
}

