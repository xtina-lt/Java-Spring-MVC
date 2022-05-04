package com.xtinacodes.projectscategories.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.xtinacodes.projectscategories.services.*;
import com.xtinacodes.projectscategories.models.*;

@Controller
public class Projects {

	@Autowired
	public ProjectServ serv;
	@Autowired
	public CategoryServ cserv;
	
	@RequestMapping("/")
	public String index(Model m){
		m.addAttribute("p", serv.selectAll());
		m.addAttribute("c", cserv.selectAll());
		return "index.jsp";
	}

	@RequestMapping("/new")
	public String showNew(Model m,
		@ModelAttribute("p") Project p,
		@ModelAttribute("c") Category c){
		return "new.jsp";
	}

	@PostMapping("/project/create")
	public String projectCreate(Model m,
		@Valid @ModelAttribute("p") Project e,
		BindingResult result){
		if (result.hasErrors()) {
			m.addAttribute("c", new Category());
			return "new.jsp";
		}
		serv.save(e);
		return "redirect:/";
	}

	@GetMapping("/project/{id}")
	public String showProject(Model m, @PathVariable("id") int id){
		Project e = serv.selectOne(id);
		m.addAttribute("output", e);
		m.addAttribute("p", e);
		m.addAttribute("notin", cserv.getUnassigned(e));
		return "project.jsp";
	}

	@PutMapping("/project/process")
	public String projectUpdate(Model m,
		@Valid @ModelAttribute("p") Project e,
		BindingResult result){
		if (result.hasErrors()) {
			m.addAttribute("output", serv.selectOne(e.getId()));
			return "project.jsp";
		}
		serv.save(e);
		return String.format("redirect:/project/%d", e.getId());
	}

	@PostMapping("/project/{id}/add")
    public String addCat( Model m,
        @PathVariable("id") int pid,
        @RequestParam(value="cid") int cid) {
        Project p = serv.selectOne(pid);
		Category c = cserv.selectOne(cid);
        p.getCategories().add(c);
		System.out.println(p.getCategories());
        serv.save(p);
        return String.format("redirect:/project/%d", pid);
    }

	@DeleteMapping("/project/{pid}/cat/delete")
	public String deleteCat(@PathVariable("pid") int pid,
		@RequestParam(value="cid") int cid){
		Project p = serv.selectOne(pid);
		Category c = cserv.selectOne(cid);
		p.getCategories().remove(c);
		serv.save(p);
		return String.format("redirect:/project/%d", pid);
	}

	@DeleteMapping("/project/{id}/delete")
	public String projectDelete(@PathVariable("id") int e){
		serv.delete(e);
		return "redirect:/";
	}
	
	
}
