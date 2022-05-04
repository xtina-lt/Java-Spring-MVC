package com.xtinacodes.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import com.xtinacodes.bookclub.models.*;
import com.xtinacodes.bookclub.services.BookServ;
import com.xtinacodes.bookclub.services.UserServ;



@Controller
public class Users {
	
	@Autowired 
	UserServ serv;
	@Autowired 
	BookServ bserv;
	
	// HOME
	@RequestMapping("")
	public String index(HttpSession session) {
		return "index.jsp";
	}
	
	// ERD
	@RequestMapping("/erd")
	public String erd() {
		return "erd.jsp";
	}
	
	// LOGIN REG
	@RequestMapping("/logoreg")
	public String test(Model m,
			@ModelAttribute("u") User u,
			@ModelAttribute("l") LoginUser l) {
		return "log.jsp";
	}
	
	// REGISTER
	@PostMapping("/register")
	public String register(Model m,
			@ModelAttribute("l") LoginUser l,
			@Valid @ModelAttribute("u") User u,
			BindingResult result,
			HttpSession session) {
		
		u = serv.register(u, result);
		
		if(result.hasErrors()) {
			return "log.jsp";
		}
		
		session.setAttribute("id", u.getId());
	
		return "redirect:/";
	}
	
	// LOGIN
	@PostMapping("/login")
	public String login(Model m,
			@Valid @ModelAttribute("l") LoginUser l,
			BindingResult result, HttpSession session) {
		
		// 1) save user
		User e = serv.login(l, result);
		
		// 2) catch errors
		if(result.hasErrors()) {
			m.addAttribute("u", new User());
			return "log.jsp";
		}
		
		// 3) save to session
		session.setAttribute("id", e.getId());
		return "redirect:/";
	}
	
	// LOGOUT
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
