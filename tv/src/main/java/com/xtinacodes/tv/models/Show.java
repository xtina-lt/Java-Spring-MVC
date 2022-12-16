package com.xtinacodes.tv.models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "shows")
public class Show {

    // VARIABLES
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // name
    @Column(unique = true)
    @NotEmpty
    @Size(min = 2, max = 60)
    private String name;
    // network
    @NotEmpty
    @Size(min = 2, max = 45)
    private String network;
    // network
    @NotEmpty
    @Size(min = 2)
    private String description;
    // USER
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;
    // RATINGS
    @OneToMany(mappedBy="show", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Rating> ratings;
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
    public Show() {
    }

    // ACCESSORS
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getNetwork(){
        return network;
    }
    public String getDescription(){
        return description;
    }
    public User getUser(){
        return user;
    }
    public List<Rating> getRatings(){
        return ratings;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public double getAverage(){
        double count = 0;
        double sum = 0;
        for (int i=0; i < ratings.size(); i++){
            count++;
            sum += ratings.get(i).getNum();
        }
        return sum / count;
    }

    // public List<Category> getCategories(){
    // return categories;
    // }
    public void getInfo() {
        System.out.println("Name: " + name);
    }
    // MUTATORS
    public int setId(int e) {
        return this.id = e;
    }
    public String setName(String e) {
        return this.name = e;
    }
    public String setNetwork(String e){
        return this.network= e;
    }
    public String setDescription(String e){
        return this.description = e;
    }
    public List<Rating> setRatings(List<Rating> e){
        return this.ratings;
    }
    public User setUser(User e){
        return this.user = e;
    }
    public Date setCreatedAt(Date e) {
        return this.createdAt = e;
    }
    public Date setUpdatedAt(Date e) {
        return this.updatedAt = e;
    }
    // public List<Category> setCategories(List<Category> e){
    // return this.categories = e;
    // }

}
