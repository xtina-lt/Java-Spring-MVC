package com.xtinacodes.tv.controllers;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

//import javax.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import com.xtinacodes.tv.models.*;
import com.xtinacodes.tv.services.*;

@Controller
public class Shows {
    
	@Autowired
	public ShowServ serv;
	@Autowired
	public UserServ userv;
	@Autowired
	public RatingServ rserv;

    @GetMapping("/dash")
	public String dash(Model m, HttpSession session) {
		if (session.getAttribute("loggedId") == null) return "redirect:/";
		m.addAttribute("output", serv.selectAll());
		return "shows.jsp";
	}

	@RequestMapping("/create")
	public String showNew(Model m,
		@ModelAttribute("s") Show s, HttpSession session){
		if (session.getAttribute("loggedId") == null) return "redirect:/";
		return "create.jsp";
	}

	@PostMapping("/show/create")
	public String showCreate(Model m,
		@Valid @ModelAttribute("s") Show s,
		BindingResult result){
		if (result.hasErrors()) return "create.jsp";
		serv.save(s);
		return "redirect:/dash";
	}

	@GetMapping("/show/{id}")
	public String showRead(Model m, @PathVariable("id") int id, HttpSession session,
		@ModelAttribute("r") Rating r){
		if (session.getAttribute("loggedId") == null) return "redirect:/";
		m.addAttribute("output", serv.selectOne(id));
		return "show.jsp";
	}

	@RequestMapping("/show/{id}/change")
	public String showChange(Model m, HttpSession session,
		@PathVariable("id") int id){
			if (session.getAttribute("loggedId") == null) return "redirect:/";
		m.addAttribute("s", serv.selectOne(id));
		return "edit.jsp";
	}

	@PutMapping("/show/process")
	public String showProcess(Model m,
		@Valid @ModelAttribute("s") Show s,
		BindingResult result){
		if (result.hasErrors()) return "edit.jsp";
		serv.save(s);
		return String.format("redirect:/show/%d", s.getId());
	}

	@DeleteMapping("/show/{id}/delete")
	public String projectDelete(@PathVariable("id") int e){
		serv.delete(e);
		return "redirect:/dash";
	}
}
