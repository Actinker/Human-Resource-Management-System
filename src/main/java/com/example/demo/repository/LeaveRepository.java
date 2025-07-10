package com.example.demo.repository;

import com.example.demo.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer> {
    // Extra: Find leaves by employee ID
    List<Leave> findByEmployeeId(Integer employeeId);
}
