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
	public String readTrips(Model m, @ModelAttribute("trip") Trip e) {
		m.addAttribute("output", ts.selectAll());
		return "trips.jsp";
	}
	
	// READ ONE
	@RequestMapping("/trip/{id}")
	public String readTrip(@PathVariable("id") Integer id, Model m) {
		m.addAttribute("output", ts.selectOne(id));
		return "trip.jsp";
	}
	
	// CREATE process
	@PostMapping("/trip/create")
	public String createTrip(@Valid @ModelAttribute("trip") Trip e,
			BindingResult error) {
		if (error.hasErrors())  return "trips.jsp";
		ts.create(e);
		return "redirect:/trips";
	}
	
	// UPDATE process
	@PostMapping("/trip/update")
	public String updateTrip(@RequestParam(value="name") String name, 
			@RequestParam(value="amount") Double amount, 
			@RequestParam(value="id") int id,
			@RequestParam(value="img") String img) {
		System.out.println("madeit");
		ts.udpate(id, name, amount, img);
		return String.format("redirect:/trip/%d", id);
	}
	
	// DELETE
	@RequestMapping("/trip/{id}/delete")
	public String deleteTrip(@PathVariable("id") int id){
		ts.delete(id);
		return "redirect:/trips";
	}

	
}
