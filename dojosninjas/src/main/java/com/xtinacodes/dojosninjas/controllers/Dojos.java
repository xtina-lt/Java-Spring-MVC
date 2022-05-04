package com.xtinacodes.dojosninjas.controllers;
import javax.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;
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
			aserv.save(e.getAddress());
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
    @RequestMapping("/dojo/{id}")
    public String dojoRead( @PathVariable("id") Integer id,
    		Model m) {
    	m.addAttribute("o", serv.selectOne(id));
    	m.addAttribute("dojos", serv.selectAll());
		// keeping output data for table seperate from form data
		// so as to not change if form data is invalid
		m.addAttribute("output", serv.selectOne(id));
    	return "/dojos/dojo.jsp";
    }
    
    // PROCESS UPDATE
    @PutMapping("/dojo/update")
    public String dojoUpdate( 
    		@Valid @ModelAttribute("o") Dojo e,
    		BindingResult result,
    		Model m) {
    		m.addAttribute("dojos", serv.selectAll());
			m.addAttribute("output", serv.selectOne(e.getId()));
    		
			try {
				aserv.save(e.getAddress());
				serv.save(e);
				return("redirect:/dojos");
			} catch (TransactionSystemException y){
				ConstraintViolationException z = (ConstraintViolationException) y.getMostSpecificCause();
				for (ConstraintViolation<?> i : z.getConstraintViolations()) {
					result.rejectValue(String.format("address.%s", i.getPropertyPath().toString()), "error.dojo", i.getMessage());
				}
			}
			return "/dojos/dojo.jsp";
		
    }

    
    // DELETE
    @DeleteMapping("/dojo/{id}/delete")
    public String dojoDelete(@PathVariable("id") int id) {
    	serv.delete(id);
    	return "redirect:/dojos";
    }

}

