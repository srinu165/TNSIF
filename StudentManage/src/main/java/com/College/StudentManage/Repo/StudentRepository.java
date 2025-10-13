package com.College.StudentManage.Repo;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.College.StudentManage.Entity.Students;


public interface StudentRepository extends JpaRepository<Students, Integer> {
	Optional<Students> findByHallTicketNo(long hallTicketNo); 
	

}