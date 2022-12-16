package com.xtinacodes.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import com.xtinacodes.bookclub.models.*;
import com.xtinacodes.bookclub.services.*;

@Controller
public class Authors {

	@Autowired
	public BookServ bserv;
	@Autowired
	public UserServ userv;
	@Autowired
	public AuthorServ serv;
	
	// NEW BOOK PROCESS
	@PostMapping("/authors/create")
	public String bookAuthorProcess(Model m,
			@Valid @ModelAttribute("a") Author a,
			BindingResult result,
			HttpSession session) {
		
		// 1) initialization
		if (session.getAttribute("loggedUser") == null) return "redirect:/logoreg";
		m.addAttribute("as", serv.selectAll());
		
		// 2) execute
		if (result.hasErrors()) return "/books/new.jsp";
		serv.save(a);
		return "redirect:/book/new";
	}

}
