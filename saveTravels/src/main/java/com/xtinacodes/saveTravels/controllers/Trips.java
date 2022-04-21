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

	private final TripServ ts;
	public Trips(TripServ e) {
		this.ts = e;
	}
	
	@RequestMapping("")
	public String index(Model m) {
		m.addAttribute("output", "Lets save and travel!");
		return "index.jsp";
	}
	
	// READ ALL
	@RequestMapping("/trips")
	public String readTrips(@ModelAttribute("trip") Trip e,
			Model m) {
		m.addAttribute("output", ts.selectAll());
		return "trips.jsp";
	}
	
	// READ ONE
	@GetMapping("/trip/{id}")
	public String readTrip(Model m,
			@PathVariable("id") Integer id) {
		m.addAttribute("output", ts.selectOne(id));
		return "trip.jsp";
	}
	
	// CREATE process
	@PostMapping("/trip/create")
	public String createTrip(@Valid @ModelAttribute("output") Trip e,
			BindingResult result) {
		ts.save(e);
		return "redirect:/trips";
	}
	
    @PutMapping("/trip/update")
    public String update(@Valid @ModelAttribute("output") Trip e, 
    		BindingResult result) {
    	ts.save(e);
    	return "redirect:/trips";
   }
	
	// DELETE
	@RequestMapping("/trip/{id}/delete")
	public String deleteTrip(@PathVariable("id") int id){
		ts.delete(id);
		return "redirect:/trips";
	}

	
}
