/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryReportRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT generate_salary_report(:month, :year)", nativeQuery = true)
    String getSalaryReport(@Param("month") int month, @Param("year") int year);
}
