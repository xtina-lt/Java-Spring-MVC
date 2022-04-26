
package com.xtinacodes.dojosninjas.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.xtinacodes.dojosninjas.models.Dojo;
import com.xtinacodes.dojosninjas.repositories.DojoRepo;
import java.util.*;

@Service
public class DojoServ {
    
	@Autowired
	private AddressServ aserv;
    private final DojoRepo r;
    
    public DojoServ(DojoRepo e) {
        this.r = e;
    }
    
    public List<Dojo> selectAll(){
        return r.findAll();
    }
    
    public Dojo selectOne(int e) {
    	Optional<Dojo> o = r.findById(e);
        Dojo result = (o.isPresent()) ? o.get() : null;
        return result;
    }
    
    public Dojo save(Dojo e) {
        return r.save(e);
    }
    
    public void delete(int e) {
    	Dojo d = selectOne(e);
    	aserv.delete(d.getAddress().getId());
    }
}

