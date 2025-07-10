package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.model.Leave;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.LeaveRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final LeaveRepository leaveRepository;

    public DepartmentController(DepartmentRepository departmentRepository,
                                EmployeeRepository employeeRepository,
                                LeaveRepository leaveRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.leaveRepository = leaveRepository;
    }

    @GetMapping("/list")
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department) {
        System.out.println("Received POST /add: " + department);
        return departmentRepository.save(department);
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable Integer id, @RequestBody Department updatedDepartment) {
        return departmentRepository.findById(id).map(existingDepartment -> {
            if (updatedDepartment.getName() != null) {
                existingDepartment.setName(updatedDepartment.getName());
            }
            return departmentRepository.save(existingDepartment);
        }).orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        if (departmentRepository.existsById(id)) {
            // Get all employees in this department
            List<Employee> employees = employeeRepository.findByDepartmentId(id);

            if (!employees.isEmpty()) {
                throw new RuntimeException("Cannot delete department with active employees.");
            }

            // Delete the department itself
            departmentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Department not found with id: " + id);
        }
    }
}
