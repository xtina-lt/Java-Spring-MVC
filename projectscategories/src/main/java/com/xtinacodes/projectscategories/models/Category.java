package com.xtinacodes.projectscategories.models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "categories")
public class Category {

    // VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    @Size(min = 2, max = 60)
    private String name;
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = new Date();
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = new Date();
    }

    // JOIN
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "projects_categories", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Project> projects;

    // CONSTRUCTOR
    public Category() {
    }

    // ACCESSORS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void getInfo() {
        System.out.println("Name: " + name);
    }

    public static String timePassed(Date now, Date e) {
        // MILISECONDS PER MINUTE HOUR DAY
        long min = 60 * 1000; //Milliseconds Per Minute
        long hr = min * 60; //Milliseconds Per Hour
        long day = hr * 24; //Milliseconds Per Day
        long month = day * 30; //Milliseconds Per Month
        long yr = day * 365; //Milliseconds Per Year

        //Difference in Milliseconds between two dates
        long timeP = now.getTime() - e.getTime();

        //Second or Seconds ago calculation
        if (timeP < min) {
            String x = (Math.round(timeP / 1000) == 1) ? String.valueOf(Math.round(timeP / 1000)) + " second ago... " : String.valueOf(Math.round(timeP / 1000) + " seconds ago...");
            return x;
        }
        //Minute or Minutes ago calculation
        else if (timeP < hr) {
            String x = (Math.round(timeP / min) == 1) ? String.valueOf(Math.round(timeP / min)) + " minute ago... " : String.valueOf(Math.round(timeP / min)) + " minutes ago... ";
            return x;
        }
        //Hour or Hours ago calculation
        else if (timeP < day) {
            String x = (Math.round(timeP / hr) == 1) ? String.valueOf(Math.round(timeP / hr)) + " hour ago... " : String.valueOf(Math.round(timeP / hr)) + " hours ago... ";
            return x;
        }
        //Day or Days ago calculation
        else if (timeP < month) {
            String x = (Math.round(timeP / day) == 1) ? String.valueOf(Math.round(timeP / day)) + " day ago... " : String.valueOf(Math.round(timeP / day)) + " days ago... ";
            return x;
        }
        //Month or Months ago calculation 
        else if (timeP < yr) {
            String x = (Math.round(timeP / month) == 1) ? String.valueOf(Math.round(timeP / month)) + "  month ago... " : String.valueOf(Math.round(timeP / month)) + "  months ago... ";
            return x;
        }
        //Year or Years ago calculation 
        else {
            String x = (Math.round(timeP / yr) == 1) ? String.valueOf(Math.round(timeP / yr)) + " year ago..." : String.valueOf(Math.round(timeP / yr)) + " years ago...";
            return x;
        }
    }

    public String getTimePassed() {
        String e = (createdAt == updatedAt || updatedAt == null) ? timePassed(new Date(), createdAt) : timePassed (new Date(), updatedAt);
        return e;
    }

    // MUTATORS
    public int setId(int e) {
        return this.id = e;
    }

    public String setName(String e) {
        return this.name = e;
    }

    public Date setCreatedAt(Date e) {
        return this.createdAt = e;
    }

    public Date setUpdatedAt(Date e) {
        return this.updatedAt = e;
    }

    public List<Project> setProjects(List<Project> e) {
        return this.projects = e;
    }

}
