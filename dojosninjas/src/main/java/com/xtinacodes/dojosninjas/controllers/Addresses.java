
package com.xtinacodes.dojosninjas.controllers;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.xtinacodes.dojosninjas.models.Address;
import com.xtinacodes.dojosninjas.services.AddressServ;

@Controller
public class Addresses {
	
	private final AddressServ serv;
	public Addresses(AddressServ e) {
		this.serv = e;
	}
	// HOME
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}

	// READ ALL and SHOW CREATE
    @RequestMapping("/addresses")
    public String addressesRead(Model m, @ModelAttribute("input") Address e) {
        m.addAttribute("output", serv.selectAll());
        return "/addresses/addresses.jsp";
    }
    
    // PROCESS CREATE
    @PostMapping("/address/create")
    public String addressCreate( @Valid @ModelAttribute("input") Address e,
    		BindingResult result,
    		Model m) {
    	System.out.println("assist");
    	m.addAttribute("output", serv.selectAll());
		if (result.hasErrors()) return "/addresses/addresses.jsp";
		e.getInfo();
		//serv.save(e);
    	return "redirect:/addresses";
    }
    
    // SHOW ONE and SHOW UPDATE
    @GetMapping("/address/{id}")
    public String addressRead( @PathVariable("id") Integer id,
    		Model m) {
    	m.addAttribute("output", serv.selectOne(id));
    	return "/addresses/address.jsp";
    }
    
    // PROCESS UPDATE
    @PutMapping("/address/update")
    public String addressUpdate( @Valid @ModelAttribute("output") Address e,
    		BindingResult result) {
    	if (result.hasErrors()) return "/addresses/address.jsp";
    	serv.save(e);
    	return String.format("redirect:/address/%d", e.getId());
    }
    
    // DELETE
    @RequestMapping("/address/{id}/delete")
    public String addressDelete(@PathVariable("id") int id) {
    	serv.delete(id);
    	return "redirect:/addresses";
    }

}
