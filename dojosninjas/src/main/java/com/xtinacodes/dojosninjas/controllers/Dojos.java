
package com.xtinacodes.dojosninjas.controllers;

import javax.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
//import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import com.xtinacodes.dojosninjas.models.*;
import com.xtinacodes.dojosninjas.services.*;


@Controller
public class Dojos {
	
	// Services
	@Autowired
	private AddressServ aserv;
	@Autowired
	private DojoServ serv;
	

	// READ ALL and SHOW CREATE
    @RequestMapping("/dojos")
    public String dojosRead(Model m, 
    		@ModelAttribute("input") Dojo e
    		) {
        m.addAttribute("output", serv.selectAll());
        return "/dojos/dojos.jsp";
    }
    
    // PROCESS CREATE
    @PostMapping("/dojo/create")
    public String dojoCreate( Model m,
    		@Valid @ModelAttribute("input") Dojo e,
    		BindingResult result) {
    	m.addAttribute("output", serv.selectAll());

		try {
			Address a = new Address(e.getAddress());
			a = aserv.save(a);
			e.setAddress(a);
			serv.save(e);
			return("redirect:/dojos");
	      } catch (ConstraintViolationException ahh){
			for (ConstraintViolation<?> i : ahh.getConstraintViolations()) {
			result.rejectValue(String.format("address.%s", i.getPropertyPath().toString()), "error.dojo", i.getMessage());
			}
			return "/dojos/dojos.jsp";
	      }

    } //route
    	
    
    
    // SHOW ONE and SHOW UPDATE
    @GetMapping("/dojo/{id}")
    public String dojoRead( @PathVariable("id") Integer id,
    		Model m) {
    	m.addAttribute("output", serv.selectOne(id));
    	m.addAttribute("addresses", aserv.selectAll());
    	return "/dojos/dojo.jsp";
    }
    
    // PROCESS UPDATE
    @PutMapping("/dojo/update")
    public String dojoUpdate( 
    		@Valid @ModelAttribute("output") Dojo e,
    		BindingResult result,
    		Model m) {
    	m.addAttribute("addresses", aserv.selectAll());
    	
		try {
			Address a = aserv.save(e.getAddress());
			e.setAddress(a);
			serv.save(e);
			return("redirect:/dojos");
	      } catch (ConstraintViolationException ahh){
			for (ConstraintViolation<?> i : ahh.getConstraintViolations()) {
			result.rejectValue(String.format("address.%s", i.getPropertyPath().toString()), "error.dojo", i.getMessage());
			}
			return "/dojos/dojos.jsp";
	      }
    }
    
    // DELETE
    @RequestMapping("/dojo/{id}/delete")
    public String dojoDelete(@PathVariable("id") int id) {
    	serv.delete(id);
    	return "redirect:/dojos";
    }

}
