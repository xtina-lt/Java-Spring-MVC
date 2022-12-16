package com.xtinacodes.tv.services;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.util.*;
import org.springframework.validation.BindingResult;
import com.xtinacodes.tv.models.LoginUser;
import com.xtinacodes.tv.models.User;
import com.xtinacodes.tv.repositories.UserRepo;

@Service
public class UserServ {
    
    @Autowired
    private UserRepo repo;

    // SELECT ALL
    public List<User> selectAll(){
        return repo.findAll();
    }
    // SELECT ONE
    public User selectOne(int e){
        return repo.findById(e).orElse(null);
    }
    // EDIT CREATE
    public User save(User e){
        return repo.save(e);
    }
    // DELETE
    public void delete(int e){
        repo.deleteById(e);
    }

    // REGISTER
    public User register(User e, BindingResult result){

        // 1 ) check email
        User u = repo.findByEmail(e.getEmail()).orElse(null);
        if (u!=null) result.rejectValue("email", "Unique", "Let's try a different email:)");
        // 2 ) check password
        if(!e.getPassword().equals(e.getConfirmP())) result.rejectValue("confirmP", "matches", "Let's play the matching game!");
        // 3) catch errors
        if (result.hasErrors()) return null;
        // 4) hash pword
        String hashed = BCrypt.hashpw(e.getPassword(), BCrypt.gensalt());
        e.setPassword(hashed);
        // 5) save and return validated user
        repo.save(e);
        return e;

    }

    // LOGIN
    public User login(LoginUser e, BindingResult result){
    
        // 1) check email
        User u = repo.findByEmail(e.getEmail()).orElse(null);
        if (u==null) result.rejectValue("email", "Unique", "Let's try a different email:)");
        if (result.hasErrors()) return null;
        // 2) check password
        if(!BCrypt.checkpw(e.getPassword(), u.getPassword())) result.rejectValue("password", "Unique", "Let's try a different password:)");
        // 3) catch errors
        if (result.hasErrors()) return null;
        // 4) save and return validated user
        return u;

    }
    

}
