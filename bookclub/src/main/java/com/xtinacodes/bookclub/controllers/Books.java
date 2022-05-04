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
public class Books {

	@Autowired
	public BookServ serv;
	@Autowired
	public UserServ userv;
	@Autowired
	public AuthorServ aserv;
	
	@RequestMapping("/bookshelf")
	public String bookshelf(Model m,
			HttpSession session) {
		if (session.getAttribute("id") == null) return "redirect:/logoreg";
		m.addAttribute("output", serv.selectAll());
		m.addAttribute("u", userv.selectOne((int) session.getAttribute("id")));
		return "/books/books.jsp";
	}
	
	// NEW BOOK SHOW
	@RequestMapping("/book/new")
	public String bookNew(Model m,
			@ModelAttribute("b") Book b,
			@ModelAttribute("a") Author a,
			HttpSession session) {
		
		m.addAttribute("as", aserv.selectAll());
		m.addAttribute("u", (int) session.getAttribute("id"));
		
		if (session.getAttribute("id") == null) return "redirect:/logoreg";
		return "/books/new.jsp";
	}
	
	// NEW BOOK PROCESS
	@PostMapping("/book/new/process")
	public String bookCreateProcess(Model m,
			@Valid @ModelAttribute("b") Book b,
			BindingResult result,
			HttpSession session) {
		
		// 1) initialization
		if (session.getAttribute("id") == null) return "redirect:/logoreg";
		m.addAttribute("a", aserv.selectAll());
		m.addAttribute("u", (int) session.getAttribute("id"));
		
		// 2) execute
		if (result.hasErrors()) return "/books/new.jsp";
		serv.save(b);
		return "redirect:/bookshelf";
	}
	
	// READ BOOK
	@GetMapping("/book/{id}")
	public String bookRead(@PathVariable("id") int id,
			Model m, HttpSession session) {
		m.addAttribute("output", serv.selectOne(id));
		m.addAttribute("u", (int) session.getAttribute("id"));
		return "/books/book.jsp";
	}
	
	// EDIT SHOW
	@GetMapping("/book/{id}/edit")
	public String bookEdit(@PathVariable("id") int id,
			Model m, HttpSession session) {
		m.addAttribute("b", serv.selectOne(id));
		m.addAttribute("a", aserv.selectAll());
		m.addAttribute("u", (int) session.getAttribute("id"));
		return "/books/edit.jsp";
	}
	
	// EDIT PROCESS
	@PutMapping("/book/process")
	public String bookEditProcess(@Valid @ModelAttribute("b") Book b,
			BindingResult result, Model m, HttpSession session) {
		m.addAttribute("a", aserv.selectAll());
		m.addAttribute("u", (int) session.getAttribute("id"));
		System.out.println("yo");
		if (result.hasErrors()) return "/books/edit.jsp";
		serv.save(b);
		return "redirect:/bookshelf";
	}

	
	@DeleteMapping("/book/{id}/delete")
	public String bookDelete(@PathVariable("id") int id) {
		serv.delete(id);
		return "redirect:/bookshelf";
	}

}
