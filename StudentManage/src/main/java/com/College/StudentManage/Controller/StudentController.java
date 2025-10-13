package com.College.StudentManage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.College.StudentManage.Entity.Students;
import com.College.StudentManage.Service.StudentService;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //Add Student
    @PostMapping("/add")
    public ResponseEntity<Students> addStudent(@RequestBody Students student) {
        Students savedStudent = studentService.addStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    //Update Student
    @PutMapping("/update")
    public ResponseEntity<Students> updateStudent(@RequestBody Students student) {
        Students updatedStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }

    //Search Student by ID
    @GetMapping("/id/{id}")
    public ResponseEntity<Students> searchStudentById(@PathVariable long id) {
        Students student = studentService.searchStudentById(id);
        return ResponseEntity.ok(student);
    }
    
    //Search Student by Hall Ticket Number
    @GetMapping("/hallticket/{ticketNo}")
    public ResponseEntity<Students> searchStudentByHallTicket(@PathVariable long ticketNo) {
        Students student = studentService.searchStudentByHallTicket(ticketNo);
        return ResponseEntity.ok(student);
    }
    
    //Delete Student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) {
        boolean deleted = studentService.deleteStudent(id);
        if (deleted) {
            return ResponseEntity.ok("Student deleted successfully.");
        } else {
            return ResponseEntity.badRequest().body("Student not found.");
        }
    }
}
