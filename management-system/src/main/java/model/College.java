package model;


	import com.college.management_system.model.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.ArrayList;
	import java.util.List;

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

	    private String contactNumber;
	    private String email;
	    private Integer establishedYear;
	    
	    // One-to-Many relationships
	    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Student> students = new ArrayList<>();
	    
	    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Placement> placements = new ArrayList<>();
	    
	    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Certificate> certificates = new ArrayList<>();

	    // Constructors
	    public College() {}

	    public College(String collegeName, String location, User collegeAdmin) {
	        this.collegeName = collegeName;
	        this.location = location;
	        this.collegeAdmin = collegeAdmin;
	    }

	    public College(String collegeName, String location, User collegeAdmin, 
	                   String contactNumber, String email, Integer establishedYear) {
	        this.collegeName = collegeName;
	        this.location = location;
	        this.collegeAdmin = collegeAdmin;
	        this.contactNumber = contactNumber;
	        this.email = email;
	        this.establishedYear = establishedYear;
	    }

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public User getCollegeAdmin() {
	        return collegeAdmin;
	    }

	    public void setCollegeAdmin(User collegeAdmin) {
	        this.collegeAdmin = collegeAdmin;
	    }

	    public String getCollegeName() {
	        return collegeName;
	    }

	    public void setCollegeName(String collegeName) {
	        this.collegeName = collegeName;
	    }

	    public String getLocation() {
	        return location;
	    }

	    public void setLocation(String location) {
	        this.location = location;
	    }

	    public String getContactNumber() {
	        return contactNumber;
	    }

	    public void setContactNumber(String contactNumber) {
	        this.contactNumber = contactNumber;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public Integer getEstablishedYear() {
	        return establishedYear;
	    }

	    public void setEstablishedYear(Integer establishedYear) {
	        this.establishedYear = establishedYear;
	    }

	    public List<Student> getStudents() {
	        return students;
	    }

	    public void setStudents(List<Student> students) {
	        this.students = students;
	    }

	    public List<Placement> getPlacements() {
	        return placements;
	    }

	    public void setPlacements(List<Placement> placements) {
	        this.placements = placements;
	    }

	    public List<Certificate> getCertificates() {
	        return certificates;
	    }

	    public void setCertificates(List<Certificate> certificates) {
	        this.certificates = certificates;
	    }

	    // Helper methods
	    public void addStudent(Student student) {
	        students.add(student);
	        student.setCollege(this);
	    }

	    public void removeStudent(Student student) {
	        students.remove(student);
	        student.setCollege(null);
	    }

	    public void addPlacement(Placement placement) {
	        placements.add(placement);
	        placement.setCollege(this);
	    }

	    public void removePlacement(Placement placement) {
	        placements.remove(placement);
	        placement.setCollege(null);
	    }

	    @Override
	    public String toString() {
	        return "College{" +
	                "id=" + id +
	                ", collegeName='" + collegeName + '\'' +
	                ", location='" + location + '\'' +
	                ", establishedYear=" + establishedYear +
	                '}';
	    }
	}

}
