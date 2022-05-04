package com.xtinacodes.saveTravels.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.xtinacodes.saveTravels.services.TripServ;
import com.xtinacodes.saveTravels.models.Trip;

@Controller
public class Trips {

	private final TripServ serv;
	public Trips(TripServ e) {
		this.serv = e;
	}
	
	@RequestMapping("/")
	public String index(Model m) {
		m.addAttribute("output", "Lets save and travel!");
		return "index.jsp";
	}
	
	// READ ALL and SHOW CREATE
	@RequestMapping("/trips")
	public String readTrips(Model m,
			@ModelAttribute("input") Trip e) {
		m.addAttribute("output", serv.selectAll());
		return "trips.jsp";
	}
	
	// CREATE process
	@PostMapping("/trip/create")
	public String createTrip(Model m,
			@Valid @ModelAttribute("input") Trip e,
			BindingResult result) {
		m.addAttribute("output", serv.selectAll());
		if (result.hasErrors()) return "trips.jsp";
		serv.save(e);
		return "redirect:/trips";
	}
	
	// READ ONE and SHOW UPDATE
	@GetMapping("/trip/{id}")
	public String readTrip(Model m,
			@PathVariable("id") Integer id) {
		m.addAttribute("output", serv.selectOne(id));
		return "trip.jsp";
	}
	
	// UPDATE process
    @PutMapping("/trip/update")
    public String update(
    		@Valid @ModelAttribute("output") Trip e, 
    		BindingResult result) {
    	System.out.println("made it");
    	if (result.hasErrors()) return "trip.jsp";
    	serv.save(e);
    	return "redirect:/trips";
   }
	
	// DELETE
	@DeleteMapping("/trip/{id}/delete")
	public String deleteTrip(@PathVariable("id") int id){
		serv.delete(id);
		return "redirect:/trips";
	}

	
}
