package repository;



import com.college.management_system.model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {
    
    // Find college by name
    Optional<College> findByCollegeName(String collegeName);
    
    // Find college by location
    List<College> findByLocation(String location);
    
    // Find college by college admin ID
    Optional<College> findByCollegeAdminId(Long adminId);
    
    // Find colleges by established year
    List<College> findByEstablishedYear(Integer establishedYear);
    
    // Search colleges by name containing keyword
    List<College> findByCollegeNameContainingIgnoreCase(String keyword);
    
    // Custom query to find colleges with student count
    @Query("SELECT c FROM College c LEFT JOIN c.students s GROUP BY c.id HAVING COUNT(s) > :minStudents")
    List<College> findCollegesWithMinStudents(@Param("minStudents") Long minStudents);
    
    // Count colleges by location
    @Query("SELECT c.location, COUNT(c) FROM College c GROUP BY c.location")
    List<Object[]> countCollegesByLocation();
    
    // Find colleges with placement drives in a specific year
    @Query("SELECT DISTINCT c FROM College c JOIN c.placements p WHERE YEAR(p.date) = :year")
    List<College> findCollegesWithPlacementsInYear(@Param("year") int year);
}