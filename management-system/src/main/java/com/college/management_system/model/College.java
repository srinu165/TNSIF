package com.college.management_system.model;

import javax.persistence.*;

import jakarta.persistence.OneToOne;

@Entity
@Table(name = "colleges")
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "college_admin_id")
    private User collegeAdmin;
    
    @Column(nullable = false, unique = true)
    private String collegeName;
    
    @Column(nullable = false)
    private String location;
    
    // Constructors
    public College() {}
    
    public College(User collegeAdmin, String collegeName, String location) {
        this.collegeAdmin = collegeAdmin;
        this.collegeName = collegeName;
        this.location = location;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getCollegeAdmin() { return collegeAdmin; }
    public void setCollegeAdmin(User collegeAdmin) { this.collegeAdmin = collegeAdmin; }
    public String getCollegeName() { return collegeName; }
    public void setCollegeName(String collegeName) { this.collegeName = collegeName; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
} 