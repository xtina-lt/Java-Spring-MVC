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
public class Categories {

	@Autowired
	public ProjectServ pserv;
	@Autowired
	public CategoryServ serv;
	
	@PostMapping("/category/create")
	public String categoryCreate(Model m,
		@Valid @ModelAttribute("c") Category c,
		BindingResult result){
		if (result.hasErrors()) {
			m.addAttribute("p", new Project());
			return "new.jsp";
		}
		serv.save(c);
		return "redirect:/";
	}

    @GetMapping("/category/{id}")
    public String showCategory(Model m, @PathVariable("id") int id){
        Category e = serv.selectOne(id);
        m.addAttribute("output", e);
        m.addAttribute("c", e);
        m.addAttribute("notin", pserv.getUnassigned(e));
        System.out.println(pserv.getUnassigned(e));
        return "category.jsp";
    }

    @PutMapping("/category/process")
    public String updateCategory(Model m,
        @Valid @ModelAttribute("c") Category e,
        BindingResult result){
        if(result.hasErrors()){
            m.addAttribute("output", serv.selectOne(e.getId()));
            return "category.jsp";
        }
        serv.save(e);
        return "redirect:/";
    }
	
    @PostMapping("/category/{id}/add")
    public String addProduct( Model m,
        @PathVariable("id") int cid,
        @RequestParam(value="pid") int pid) {
        Category c = serv.selectOne(cid);
        Project p = pserv.selectOne(pid);
        c.getProjects().add(p);
        serv.save(c);
        return String.format("redirect:/category/%d", cid);
    }

    @DeleteMapping("/category/{id}/delete")
    public String deleteCategory(@PathVariable("id") int e){
        serv.delete(e);
        return "redirect:/";
    }
    
	
}

