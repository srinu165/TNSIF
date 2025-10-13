package service;

package com.college.management_system.service;

import com.college.management_system.model.College;
import com.college.management_system.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeService {
    
    @Autowired
    private CollegeRepository collegeRepository;
    
    // Get all colleges
    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }
    
    // Get college by ID
    public Optional<College> getCollegeById(Long id) {
        return collegeRepository.findById(id);
    }
    
    // Get college by name
    public Optional<College> getCollegeByName(String name) {
        return collegeRepository.findByCollegeName(name);
    }
    
    // Create new college
    public College createCollege(College college) {
        // Validate college name uniqueness
        if (collegeRepository.findByCollegeName(college.getCollegeName()).isPresent()) {
            throw new RuntimeException("College with name '" + college.getCollegeName() + "' already exists");
        }
        return collegeRepository.save(college);
    }
    
    // Update college
    public College updateCollege(Long id, College collegeDetails) {
        Optional<College> optionalCollege = collegeRepository.findById(id);
        if (optionalCollege.isPresent()) {
            College college = optionalCollege.get();
            
            // Check if college name is being changed and if it's unique
            if (!college.getCollegeName().equals(collegeDetails.getCollegeName()) &&
                collegeRepository.findByCollegeName(collegeDetails.getCollegeName()).isPresent()) {
                throw new RuntimeException("College with name '" + collegeDetails.getCollegeName() + "' already exists");
            }
            
            // Update fields
            college.setCollegeName(collegeDetails.getCollegeName());
            college.setLocation(collegeDetails.getLocation());
            college.setCollegeAdmin(collegeDetails.getCollegeAdmin());
            college.setContactNumber(collegeDetails.getContactNumber());
            college.setEmail(collegeDetails.getEmail());
            college.setEstablishedYear(collegeDetails.getEstablishedYear());
            
            return collegeRepository.save(college);
        }
        throw new RuntimeException("College not found with id: " + id);
    }
    
    // Delete college
    public void deleteCollege(Long id) {
        if (collegeRepository.existsById(id)) {
            collegeRepository.deleteById(id);
        } else {
            throw new RuntimeException("College not found with id: " + id);
        }
    }
    
    // Get colleges by location
    public List<College> getCollegesByLocation(String location) {
        return collegeRepository.findByLocation(location);
    }
    
    // Search colleges by name
    public List<College> searchCollegesByName(String keyword) {
        return collegeRepository.findByCollegeNameContainingIgnoreCase(keyword);
    }
    
    // Get college by admin ID
    public Optional<College> getCollegeByAdminId(Long adminId) {
        return collegeRepository.findByCollegeAdminId(adminId);
    }
    
    // Check if college exists
    public boolean collegeExists(Long id) {
        return collegeRepository.existsById(id);
    }
    
    // Get colleges with minimum number of students
    public List<College> getCollegesWithMinStudents(Long minStudents) {
        return collegeRepository.findCollegesWithMinStudents(minStudents);
    }
    
    // Get college statistics
    public Long getTotalColleges() {
        return collegeRepository.count();
    }
}
