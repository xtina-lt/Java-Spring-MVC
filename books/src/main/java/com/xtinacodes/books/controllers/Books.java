package com.xtinacodes.books.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.*;
import com.xtinacodes.books.services.*;
import com.xtinacodes.books.models.*;

@Controller
public class Books {
	private final BookServ bs;
	
	public Books(BookServ e) {
		this.bs = e;
	}
	
	
	@RequestMapping("/")
	public String index(Model m) {
		m.addAttribute("greet", "Lets check out some books!");
		return "index.jsp";
	}
	
	@RequestMapping("/books")
	public String books(Model m){
		//System.out.println(bs.allBooks());
		m.addAttribute("output", bs.allBooks());
		//for (Book i: bs.allBooks()) i.getInfo();
		return "Books.jsp";
	}
	
	@RequestMapping("/book/{id}")
	public String finding(@PathVariable("id") Integer id, Model m){
		m.addAttribute("output", bs.findBook(id));
		return "book.jsp";
	}
	
	@RequestMapping("/bookfind/{whoCares}")
	public List<Book> bookLook(@PathVariable("whoCares") String whoCares){
//		System.out.println(whoCares);
//		System.out.println(whoCares.getClass());
//		System.out.println(bs.findBy(whoCares).getClass());
		for (Book i : bs.findBy(whoCares)) i.getInfo();
		return bs.findBy(whoCares);
	}
	
	@RequestMapping("/book/new")
	public String newBook() {
		return "create.jsp";
	}
	
	@PostMapping("/create")
	public String create(@RequestParam Map<String, Object> requests) {
		requests.replace("pages", Integer.parseInt( (String) requests.get("pages") ) );
		Book e = new Book(requests);
		bs.save(e);
		System.out.println(e.getPages());
		return "redirect:/books";
	}
	
	@RequestMapping("/book/{id}/update")
	public String bookUpdate(@PathVariable("id") Integer id, Model m) {
		System.out.println(id);
		m.addAttribute("output", bs.findBook(id));
		return "edit.jsp";
	}
	
	@PostMapping("/update")
	public String edit(@RequestParam Map<String, Object> requests) {
		requests.replace("id", Integer.parseInt( (String) requests.get("id") ) );
		Book e = bs.findBook((int) requests.get("id"));
		e.setPages(requests.get("pages"));
		e.setTitle(requests.get("title"));
		bs.save(e);
		return "redirect:/books";
	}
	
}
