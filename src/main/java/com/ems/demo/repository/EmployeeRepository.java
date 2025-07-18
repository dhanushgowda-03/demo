package com.ems.demo.repository;
import java.util.List;
import java.util.Optional;
import com.ems.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Optional: custom query method
    Optional<Employee> findByUsername(String username);
    List<Employee> findByNameContainingIgnoreCase(String name);
    Optional<Employee> findByEmail(String email);

}
