
package com.xtinacodes.dojosninjas.services;
import org.springframework.stereotype.*;
import com.xtinacodes.dojosninjas.models.Ninja;
import com.xtinacodes.dojosninjas.repositories.NinjaRepo;
import java.util.*;

@Service
public class NinjaServ {
    
    private final NinjaRepo r;
    
    public NinjaServ(NinjaRepo e) {
        this.r = e;
    }
    
    public List<Ninja> selectAll(){
        return r.findAll();
    }
    
    public Ninja selectOne(int e) {
    	Optional<Ninja> o = r.findById(e);
    	Ninja result = (o.isPresent()) ? o.get() : null;
        return result;
    }
    
    public Ninja save(Ninja e) {
        return r.save(e);
    }
    
    public void delete(int e) {
        r.deleteById(e);
    }
}

