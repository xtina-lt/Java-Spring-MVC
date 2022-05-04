package com.xtinacodes.bookclub.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.validation.BindingResult;
import com.xtinacodes.bookclub.models.User;
import com.xtinacodes.bookclub.models.LoginUser;
import com.xtinacodes.bookclub.repositories.UserRepo;
import java.util.*;

@Service
public class UserServ {

	@Autowired
	private UserRepo repo;
	
	
	// SELECT ALL
	public List<User> selectAll(){
		return repo.findAll();
	}
	
	// SELECT ONE
	public User selectOne(int id) {
		return repo.findById(id).orElse(null);
	}
	
	// SAVE / EDIT
	public User save(User e) {
		return repo.save(e);
	}
	
	// DELETE
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	// REGISTER
	public User register(User e, BindingResult result) {
		
		// 1) check email and password
		User r = repo.findByEmail(e.getEmail()).orElse(null);
		if (r != null) result.rejectValue("email", "Unique", "Let's try a different email :)");
		if(e.getPassword() != e.getConfirmP()) result.rejectValue("confirmP", "Matches", "Lets play the matching game!");
		
		// 2) return errors
		if (result.hasErrors()) return null;
		
		// 3) hash pword
		String hashed = BCrypt.hashpw(e.getPassword(), BCrypt.gensalt());
		e.setPassword(hashed);
		
		// 4) save user
		e = repo.save(e);
		System.out.println("new user added");
		e.getInfo();
		
		return e;
	}
	
	// LOGIN
	public User login(LoginUser e, BindingResult result) {
		
		// 1) check email
		Optional<User> o = repo.findByEmail(e.getEmail());
		if (!o.isPresent()) {
			result.rejectValue("email", "Matches", "Errrr wrong!");
			System.out.println("SAME EMAIL");
			return null;
		} else {
			// 2) get user data from optional
			User u = o.get();
			
			// 3) check password from form and match with optional user
			if(!BCrypt.checkpw(e.getPassword(), u.getPassword()));
			
			// 4) catch errors
			if(result.hasErrors()) return null;
			
			// 5) return validated user
			System.out.println("logged in user: ");
			u.getInfo();
			return u;
		}
	}
}
