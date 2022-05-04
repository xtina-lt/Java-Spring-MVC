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
public class Ninjas {
	
	// Services
	@Autowired
	private AddressServ aserv;
	@Autowired
	private NinjaServ serv;
	@Autowired
	private DojoServ dserv;

	

	// READ ALL and SHOW CREATE
    @RequestMapping("/ninjas")
    public String ninjasRead(Model m, 
    		@ModelAttribute("input") Ninja e
    		) {
        m.addAttribute("output", serv.selectAll());
        m.addAttribute("dojos", dserv.selectAll());
        return "/ninjas/ninjas.jsp";
    }
    
    // PROCESS CREATE
    @PostMapping("/ninja/create")
    public String ninjaCreate( Model m,
    		@Valid @ModelAttribute("input") Ninja e,
    		BindingResult result) {
    	m.addAttribute("output", serv.selectAll());
    	m.addAttribute("dojos", dserv.selectAll());
    	
		try {
			aserv.save(e.getAddress());
			serv.save(e);
			return("redirect:/ninjas");
	      } catch (ConstraintViolationException ahh){
			for (ConstraintViolation<?> i : ahh.getConstraintViolations()) {
			result.rejectValue(String.format("address.%s", i.getPropertyPath().toString()), "error.dojo", i.getMessage());
			}
			return "/ninjas/ninjas.jsp";
	      }

    } //route
    	
    
    
//    // SHOW ONE and SHOW UPDATE
//    @GetMapping("/ninja/{id}")
//    public String ninjaRead( @PathVariable("id") Integer id,
//    		@ModelAttribute("la") Ninja e,
//    		Model m) {
//    	m.addAttribute("output", serv.selectOne(id));
//    	m.addAttribute("dojos", dserv.selectAll());
//    	return "/ninjas/ninja.jsp";
//    }
//    
//    // PROCESS UPDATE
//    @PutMapping("/ninja/update")
//    public String ninjaUpdate( 
//    		@Valid @ModelAttribute("la") Ninja e,
//    		BindingResult result,
//    		Model m) {
//    	m.addAttribute("dojos", dserv.selectAll());
//    	m.addAttribute("output", serv.selectOne(e.getId()));
//    	e.getAddress().getInfo();
//		try {
//			aserv.save(e.getAddress());
//			serv.save(e);
//			return("redirect:/ninjas");
//	      } catch (ConstraintViolationException ahh){
//			for (ConstraintViolation<?> i : ahh.getConstraintViolations()) {
//			result.rejectValue(String.format("address.%s", i.getPropertyPath().toString()), "error.dojo", i.getMessage());
//			}
//			return "/ninjas/ninja.jsp";
//	      }
//    }
    
    // SHOW ONE and SHOW UPDATE
    @GetMapping("/ninja/{id}")
    public String ninjaRead( @PathVariable("id") Integer id,
    		Model m) {
    	m.addAttribute("output", serv.selectOne(id));
    	m.addAttribute("dojos", dserv.selectAll());
    	return "/ninjas/ninja.jsp";
    }
    
    // PROCESS UPDATE
    @PutMapping("/ninja/update")
    public String ninjaUpdate( 
    		@Valid @ModelAttribute("output") Ninja e,
    		BindingResult result,
    		Model m) {
    	m.addAttribute("dojos", dserv.selectAll());

		try {
			Address a = aserv.save(e.getAddress());
			e.setAddress(a);
			serv.save(e);
			return("redirect:/ninjas");
	      } catch (ConstraintViolationException ahh){
			for (ConstraintViolation<?> i : ahh.getConstraintViolations()) {
			result.rejectValue(String.format("address.%s", i.getPropertyPath().toString()), "error.dojo", i.getMessage());
			}
			return "/ninjas/ninja.jsp";
	      }
    }
    
    // DELETE
    @RequestMapping("/ninja/{id}/delete")
    public String ninjaDelete(@PathVariable("id") int id) {
    	serv.delete(id);
    	return "redirect:/ninjas";
    }



}

