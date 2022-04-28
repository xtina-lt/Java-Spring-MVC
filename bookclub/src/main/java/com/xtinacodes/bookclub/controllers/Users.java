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
	UserServ userv;
	@Autowired 
	BookServ bserv;
	
	// HOME
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	// ERD
	@RequestMapping("/erd")
	public String erd() {
		return "erd.jsp";
	}
	
	// LOGIN REG
	@RequestMapping("/loginOreg")
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
		
		u = userv.register(u, result);
		
		if(result.hasErrors()) {
			return "log.jsp";
		}
		
		session.setAttribute("user", u.getId());
		System.out.println("session: " + session);
		
		return "redirect:/";
	}
	
	// LOGIN
	@PostMapping("/login")
	public String login(Model m,
			@Valid @ModelAttribute("l") LoginUser l,
			BindingResult result, HttpSession session) {
		
		// 1) save user
		User e = userv.login(l, result);
		
		// 2) catch errors
		if(result.hasErrors()) {
			m.addAttribute("u", new User());
			return "log.jsp";
		}
		
		// 3) save to session
		session.setAttribute("user", e.getId());
		System.out.println("session: " + session.getAttribute("user"));
		return "redirect:/";
	}
	
	
}
