package com.xtinacodes.babynames.controllers;
import javax.servlet.http.HttpSession;
import javax.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import com.xtinacodes.babynames.models.*;
import com.xtinacodes.babynames.services.*;

@Controller
public class Names {
    
	@Autowired
	public NameServ serv;
	@Autowired
	public UserServ userv;

    @GetMapping("/dash")
	public String dash(Model m, HttpSession session) {
		if (session.getAttribute("loggedId") == null) return "redirect:/";
		m.addAttribute("output", serv.selectAll());
		return "names.jsp";
	}
    
    @RequestMapping("/vote/{id}")
    public String vote(Model m, HttpSession session, @PathVariable("id") int id){
    	Name e = serv.selectOne(id);
    	e.getLikes().add(userv.selectOne((int) session.getAttribute("loggedId")));
    	serv.esave(e);
    	return "redirect:/dash";
    }

	@GetMapping("/create")
	public String nameNew(Model m,
		@ModelAttribute("e") Name e, HttpSession session){
		if (session.getAttribute("loggedId") == null) return "redirect:/";
		return "create.jsp";
	}

	@PostMapping("/name/create")
	public String nameCreate(Model m,
		@Valid @ModelAttribute("e") Name e,
		BindingResult result){
		serv.save(e, result);
		if (result.hasErrors()) return "create.jsp";
		return "redirect:/dash";
	}

	@GetMapping("/name/{id}")
	public String nameRead(Model m, @PathVariable("id") int id, HttpSession session){
		if (session.getAttribute("loggedId") == null) return "redirect:/";
		m.addAttribute("output", serv.selectOne(id));
		return "name.jsp";
	}

	@RequestMapping("/name/{id}/change")
	public String nameChange(Model m, HttpSession session,
		@PathVariable("id") int id){
			if (session.getAttribute("loggedId") == null) return "redirect:/";
		m.addAttribute("e", serv.selectOne(id));
		return "edit.jsp";
	}

	@PutMapping("/name/process")
	public String showProcess(Model m,
		@Valid @ModelAttribute("e") Name e,
		BindingResult result){
		if (result.hasErrors()) {return "edit.jsp";}
		serv.esave(e);
		return String.format("redirect:/name/%d", e.getId());
	}

	@DeleteMapping("/name/{id}/delete")
	public String projectDelete(@PathVariable("id") int e){
		serv.delete(e);
		return "redirect:/dash";
	}
}
