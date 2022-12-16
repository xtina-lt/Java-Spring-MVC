package com.xtinacodes.tv.models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ratings")
public class Rating {

    // VARIABLES
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // NUM
    @NotEmpty
    private int num;
    // Users
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    // Shows
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="show_id")
    private Show show;
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
    public Rating() {
    }

    // ACCESSORS
    public int getId() {
        return id;
    }
    public int getNum() {
        return num;
    }
    public User getUser(){
        return user;
    }
    public Show getShow(){
        return show;
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
    public int setNum(int e) {
        return this.num = e;
    }
    public User setUser(User e){
        return this.user = e;
    }
    public Show setShow(Show e){
        return this.show = e;
    }
    public Date setCreatedAt(Date e) {
        return this.createdAt = e;
    }
    public Date setUpdatedAt(Date e) {
        return this.updatedAt = e;
    }

}
