package com.xtinacodes.babynames.models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "names")
public class Name {

    // VARIABLES
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // name
    @NotEmpty
    @Size(min = 2, max = 45)
    private String name;
    // gender
    @NotEmpty
    @Size(min = 2, max = 45)
    private String gender;
    // origin
    @NotEmpty
    @Size(min = 2, max = 45)
    private String origin;
    // meaning
    @NotEmpty
    @Size(min = 2)
    private String meaning;
    // USER
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;
    // LIKES
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_names", 
        joinColumns = @JoinColumn(name = "name_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> likes;
    // created at
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @PrePersist
    public void onCreate() {
        this.createdAt = new Date();
    }
    // updated at
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
    @PreUpdate
    public void onUpdate() {
        this.updatedAt = new Date();
    }

    // CONSTRUCTOR
    public Name() {
    }

    // ACCESSORS
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getGender(){
        return gender;
    }
    public String getOrigin(){
        return origin;
    }
    public String getMeaning(){
        return meaning;
    }
    public User getUser() {
    	return user;
    }
    public List<User> getLikes(){
    	return likes;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }

    // MUTATORS
    public int setId(int e) {
        return this.id = e;
    }
    public String setName(String e) {
        return this.name = e;
    }
    public String setGender(String e){
        return this.gender= e;
    }
    public String setOrigin(String e){
        return this.origin = e;
    }
    public String setMeaning(String e){
        return this.meaning = e;
    }
    public User setUser(User e) {
    	return this.user = e;
    }
    public List<User> setLikes(List<User> e){
    	return this.likes = e;
    }
    public Date setCreatedAt(Date e) {
        return this.createdAt = e;
    }
    public Date setUpdatedAt(Date e) {
        return this.updatedAt = e;
    }

}
