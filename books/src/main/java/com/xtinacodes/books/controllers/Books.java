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
	public List<Book> books(){
		for (Book i : bs.allBooks()) i.getInfo();
		return bs.allBooks();
	}
	
	@RequestMapping("/book/{whoCares}")
	public List<Book> bookLook(@PathVariable("whoCares") String whoCares){
//		System.out.println(whoCares);
//		System.out.println(whoCares.getClass());
//		System.out.println(bs.findBy(whoCares).getClass());
		for (Book i : bs.findBy(whoCares)) i.getInfo();
		return bs.findBy(whoCares);
	}
	
	@PostMapping("/process")
	public Book create(@RequestParam Map<String, Object> requests) {
		Book e = new Book(requests);
		return e;
	}
	
}
