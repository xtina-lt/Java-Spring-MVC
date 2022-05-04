package com.xtinacodes.books.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.*;
import com.xtinacodes.books.services.*;
import com.xtinacodes.books.models.*;

@Controller
public class Books {
	private final BookServ serv;
	
	public Books(BookServ e) {
		this.serv = e;
	}
	
	
	@RequestMapping("/")
	public String index(Model m) {
		m.addAttribute("greet", "Lets check out some books!");
		return "index.jsp";
	}
	
	@RequestMapping("/books")
	public String books(Model m){
		m.addAttribute("output", serv.allBooks());
		return "Books.jsp";
	}
	
	@RequestMapping("/book/{id}")
	public String finding(Model m,
			@PathVariable("id") Integer id){
		m.addAttribute("output", serv.selectOne(id));
		return "book.jsp";
	}
	
	@RequestMapping("/bookfind/{whoCares}")
	public List<Book> bookLook(@PathVariable("whoCares") String whoCares){
		for (Book i : serv.findBy(whoCares)) i.getInfo();
		return serv.findBy(whoCares);
	}
	
	@RequestMapping("/book/new")
	public String newBook() {
		return "create.jsp";
	}
	
	@PostMapping("/create")
	public String create(@RequestParam Map<String, Object> requests) {
		requests.replace("pages", Integer.parseInt( (String) requests.get("pages") ) );
		Book e = new Book(requests);
		serv.save(e);
		System.out.println(e.getPages());
		return "redirect:/books";
	}
	
	@RequestMapping("/book/{id}/update")
	public String bookUpdate(@PathVariable("id") Integer id, Model m) {
		System.out.println(id);
		m.addAttribute("output", serv.selectOne(id));
		return "edit.jsp";
	}
	
	@PostMapping("/update")
	public String edit(@RequestParam Map<String, Object> requests) {
		requests.replace("id", Integer.parseInt( (String) requests.get("id") ) );
		Book e = serv.selectOne((int) requests.get("id"));
		e.setPages(requests.get("pages"));
		e.setTitle(requests.get("title"));
		serv.save(e);
		return "redirect:/books";
	}
	
}
