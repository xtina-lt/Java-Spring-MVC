package com.xtinacodes.logreg.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import com.xtinacodes.logreg.models.*;
import com.xtinacodes.logreg.services.*;

@Controller
public class Users {
	
	@Autowired 
	UserServ serv;
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		return "index.jsp";
	}
	
	@RequestMapping("/logoreg")
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
		session.setAttribute("id", u.getId());
		return "redirect:/";
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

	// DASHBOARD
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session){
		if (session.getAttribute("id") == null) return "redirect:/login";
		return "dashboard.jsp";
	}
	
}
