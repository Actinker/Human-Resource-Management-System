package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.Leave;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.LeaveRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employees")
public class EmployeeController {

   private final EmployeeRepository employeeRepository;
   private final LeaveRepository leaveRepository;

    public EmployeeController(EmployeeRepository employeeRepository, LeaveRepository leaveRepository) {
        this.employeeRepository = employeeRepository;
        this.leaveRepository = leaveRepository;
    }
    
    
    @GetMapping("/list")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/update/{id}")
    public void updateEmployee(@PathVariable Integer id, @RequestBody Employee updatedEmployee) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        
        Employee existingEmployee = employeeRepository.findById(id).get();
        
        // Update only if the fields are not null
        if (updatedEmployee.getName() != null) {
            existingEmployee.setName(updatedEmployee.getName());
        }
        if (updatedEmployee.getBaseSalary() != null) {
            existingEmployee.setBaseSalary(updatedEmployee.getBaseSalary());
        }
        if (updatedEmployee.getDepartmentId() != null) {
            existingEmployee.setDepartmentId(updatedEmployee.getDepartmentId());
        }
        if (updatedEmployee.getCode() != null) {
            existingEmployee.setCode(updatedEmployee.getCode());
        }
        if (updatedEmployee.getDob() != null) {
            existingEmployee.setDob(updatedEmployee.getDob());
        }
        if (updatedEmployee.getContactNo() != null) {
            existingEmployee.setContactNo(updatedEmployee.getContactNo());
        }
        if (updatedEmployee.getStateId() != null) {
            existingEmployee.setStateId(updatedEmployee.getStateId());
        }
        if (updatedEmployee.getAddress1() != null) {
        existingEmployee.setAddress1(updatedEmployee.getAddress1());
        }
        if (updatedEmployee.getAddress2() != null) {
            existingEmployee.setAddress2(updatedEmployee.getAddress2());
        }
        if (updatedEmployee.getAddress3() != null) {
            existingEmployee.setAddress3(updatedEmployee.getAddress3());
        }
        if (updatedEmployee.getPincode() != null) {
            existingEmployee.setPincode(updatedEmployee.getPincode());
        }
        
        employeeRepository.save(existingEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        if (employeeRepository.existsById(id)) {
            // First delete all associated leave records
            List<Leave> employeeLeaves = leaveRepository.findByEmployeeId(id);
            leaveRepository.deleteAll(employeeLeaves);
            // Then delete the employee
            employeeRepository.deleteById(id);
        } 
    }
}
