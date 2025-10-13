package controller;

package com.college.management_system.controller;

import com.college.management_system.model.College;
import com.college.management_system.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/colleges")
@CrossOrigin(origins = "*")
public class CollegeController {
    
    @Autowired
    private CollegeService collegeService;
    
    // Get all colleges
    @GetMapping
    public ResponseEntity<List<College>> getAllColleges() {
        try {
            List<College> colleges = collegeService.getAllColleges();
            return new ResponseEntity<>(colleges, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Get college by ID
    @GetMapping("/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable Long id) {
        try {
            Optional<College> college = collegeService.getCollegeById(id);
            if (college.isPresent()) {
                return new ResponseEntity<>(college.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Get college by name
    @GetMapping("/name/{name}")
    public ResponseEntity<College> getCollegeByName(@PathVariable String name) {
        try {
            Optional<College> college = collegeService.getCollegeByName(name);
            if (college.isPresent()) {
                return new ResponseEntity<>(college.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Create new college
    @PostMapping
    public ResponseEntity<?> createCollege(@RequestBody College college) {
        try {
            College savedCollege = collegeService.createCollege(college);
            return new ResponseEntity<>(savedCollege, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to create college");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Update college
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCollege(@PathVariable Long id, @RequestBody College collegeDetails) {
        try {
            College updatedCollege = collegeService.updateCollege(id, collegeDetails);
            return new ResponseEntity<>(updatedCollege, HttpStatus.OK);
        } catch (RuntimeException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to update college");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Delete college
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCollege(@PathVariable Long id) {
        try {
            collegeService.deleteCollege(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "College deleted successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Failed to delete college");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Get colleges by location
    @GetMapping("/location/{location}")
    public ResponseEntity<List<College>> getCollegesByLocation(@PathVariable String location) {
        try {
            List<College> colleges = collegeService.getCollegesByLocation(location);
            return new ResponseEntity<>(colleges, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Search colleges by name
    @GetMapping("/search")
    public ResponseEntity<List<College>> searchColleges(@RequestParam String keyword) {
        try {
            List<College> colleges = collegeService.searchCollegesByName(keyword);
            return new ResponseEntity<>(colleges, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Get college by admin ID
    @GetMapping("/admin/{adminId}")
    public ResponseEntity<College> getCollegeByAdminId(@PathVariable Long adminId) {
        try {
            Optional<College> college = collegeService.getCollegeByAdminId(adminId);
            if (college.isPresent()) {
                return new ResponseEntity<>(college.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Get colleges with minimum students
    @GetMapping("/min-students/{minStudents}")
    public ResponseEntity<List<College>> getCollegesWithMinStudents(@PathVariable Long minStudents) {
        try {
            List<College> colleges = collegeService.getCollegesWithMinStudents(minStudents);
            return new ResponseEntity<>(colleges, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Get college statistics
    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Object>> getCollegeStatistics() {
        try {
            Map<String, Object> stats = new HashMap<>();
            stats.put("totalColleges", collegeService.getTotalColleges());
            // Add more statistics as needed
            return new ResponseEntity<>(stats, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Health check endpoint
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "College Service is running");
        response.put("timestamp", java.time.LocalDateTime.now().toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
