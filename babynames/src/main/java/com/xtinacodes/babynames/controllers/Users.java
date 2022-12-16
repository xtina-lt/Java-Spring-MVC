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
public class Users {
	
	@Autowired 
	UserServ serv;
	

	@RequestMapping("/")
	public String test(Model m,
			@ModelAttribute("u") User u,
			@ModelAttribute("l") LoginUser l) {
		return "log.jsp";
	}
	
	@PostMapping("/register")
	public String register(Model m,
			@Valid @ModelAttribute("u") User u,
			BindingResult result,
			HttpSession session) {
		// 1) save user
		u = serv.register(u, result);
		// 2) catch errors
		if(result.hasErrors()) {
			m.addAttribute("l", new LoginUser());
			return "log.jsp";
		}
		// 3) save to session
		session.setAttribute("loggedId", u.getId());
		session.setAttribute("loggedName", u.getName());
		return "redirect:/dash";
	}
	
	@PostMapping("/login")
	public String login(Model m,
			@Valid @ModelAttribute("l") LoginUser l,
			BindingResult result, HttpSession session) {
		
		// 1) cast loginuser
		User e = serv.login(l, result);
		// 2) catch errors
		if(result.hasErrors()) {
			m.addAttribute("u", new User());
			System.out.println("error");
			return "log.jsp";
		}
		System.out.println("no error");
		// 3) save to session
		session.setAttribute("loggedId", e.getId());
		session.setAttribute("loggedName", e.getName());
		return "redirect:/dash";
	}
	
	// LOGOUT
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
