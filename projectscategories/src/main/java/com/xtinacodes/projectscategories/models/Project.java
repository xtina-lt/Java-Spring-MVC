package com.xtinacodes.projectscategories.models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="projects")
public class Project {

    // VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    @Size(min=2, max=60)
    private String name;
    @NotEmpty
    @Size(min=2)
    private String description;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @PrePersist
    public void onCreate(){
        this.createdAt = new Date();
    }
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    @PreUpdate
    public void onUpdate(){
        this.updatedAt = new Date();
    }
    // JOIN
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name="projects_categories",
        joinColumns = @JoinColumn(name="project_id"),
        inverseJoinColumns = @JoinColumn(name="category_id"))
    private List<Category> categories;
    
    // CONSTRUCTOR
    public Project() {}

    // ACCESSORS
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public List<Category> getCategories(){
        return categories;
    }
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
    public String setDescription(String e) {
        return this.description = e;
    }
    public Date setCreatedAt(Date e) {
        return this.createdAt = e;
    }
    public Date setUpdatedAt(Date e) {
        return this.updatedAt = e;
    }
    public List<Category> setCategories(List<Category> e){
        return this.categories = e;
    }

}


