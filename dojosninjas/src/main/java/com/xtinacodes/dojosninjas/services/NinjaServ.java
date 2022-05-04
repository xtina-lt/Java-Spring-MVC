
package com.xtinacodes.dojosninjas.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import com.xtinacodes.dojosninjas.models.Ninja;
import com.xtinacodes.dojosninjas.repositories.NinjaRepo;
import java.util.*;

@Service
public class NinjaServ {
    
    private final NinjaRepo repo;
    @Autowired
    private AddressServ aserv;
    
    public NinjaServ(NinjaRepo e) {
        this.repo = e;
    }
    
    public List<Ninja> selectAll(){
        return repo.findAll();
    }
    
    public Ninja selectOne(int e) {
        return repo.findById(e).orElse(null);
    }
    
    public Ninja save(Ninja e) {
        return repo.save(e);
    }
    
    public void delete(int e) {
    	Ninja n = selectOne(e);
        aserv.delete(n.getAddress().getId());
    }
}

