package com.College.StudentManage.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.College.StudentManage.Entity.Students;
import com.College.StudentManage.Repo.StudentRepository;



@Service
public class StudentService {

    @Autowired
    private StudentRepository sr;

    //Add a new Student
    public Students addStudent(Students student) {
        return sr.save(student);
    }

    //Update an existing Student
    public Students updateStudent(Students student) {
        if (sr.existsById(student.getId())) {
            return sr.save(student);
        } else {
            throw new RuntimeException("Student not found with ID: " + student.getId());
        }
    }

    //Search Student by ID
    public Students searchStudentById(long id) {
        Optional<Students> student = sr.findById((int) id);
        return student.orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

    //Search Student by Hall Ticket Number
    public Students searchStudentByHallTicket(long ticketNo) {
        // Corrected method: Using the custom finder from StudentRepo
        Optional<Students> student = sr.findByHallTicketNo(ticketNo); 
        return student.orElseThrow(() -> new RuntimeException("Student not found with Hall Ticket No: " + ticketNo));
    }

    //Add Certificate
    public boolean addCertificate(long studentId, String certificate) {
        Students student = sr.findById((int) studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));
        student.setCertificate(certificate);
        sr.save(student);
        return true;
    }

    //Update Certificate
    public boolean updateCertificate(long studentId, String certificate) {
        Students student = sr.findById((int) studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));
        student.setCertificate(certificate);
        sr.save(student);
        return true;
    }

    //Delete Student
    public boolean deleteStudent(long id) {
        if (sr.existsById((int) id)) {
            sr.deleteById((int) id);
            return true;
        } else {
            return false;
        }
    }
}