package com.example.demo.controller;

import com.example.demo.model.Leave;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.LeaveRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

    private final LeaveRepository leaveRepository;
    private final EmployeeRepository employeeRepository;

    public LeaveController(LeaveRepository leaveRepository, EmployeeRepository employeeRepository) {
        this.leaveRepository = leaveRepository;
        this.employeeRepository = employeeRepository;
    }

    // GET all leaves
    @GetMapping("/list")
    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    // GET leaves for a specific employee
    @GetMapping("/employee/{employeeId}")
    public List<Leave> getLeavesByEmployee(@PathVariable Integer employeeId) {
        return leaveRepository.findByEmployeeId(employeeId);
    }

    // POST new leave
    @PostMapping("/add")
    public Leave addLeave(@RequestBody Leave leave) {
        Integer employeeId = leave.getEmployee().getId();
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));
        
        leave.setEmployee(employee);
        // Ensure halfdayYN is 'Y' or 'N', default to 'N' if invalid or null
        if (leave.getHalfdayYN() != 'Y' && leave.getHalfdayYN() != 'N') {
            leave.setHalfdayYN('N');
        }
        return leaveRepository.save(leave);
    }

    // PUT update leave
    @PutMapping("/update/{id}")
    public Leave updateLeave(@PathVariable Integer id, @RequestBody Leave updatedLeave) {
        Leave existingLeave = leaveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave not found with id: " + id));

        existingLeave.setLeaveDate(updatedLeave.getLeaveDate());
        existingLeave.setRemarks(updatedLeave.getRemarks());
        
        // Update halfdayYN if valid, else keep existing value
        char newHalfdayYN = updatedLeave.getHalfdayYN();
        if (newHalfdayYN == 'Y' || newHalfdayYN == 'N') {
            existingLeave.setHalfdayYN(newHalfdayYN);
        }

        // Optional: handle reassignment to another employee
        if (updatedLeave.getEmployee() != null) {
            Employee employee = employeeRepository.findById(updatedLeave.getEmployee().getId())
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
            existingLeave.setEmployee(employee);
        }

        return leaveRepository.save(existingLeave);
    }

    // DELETE leave
    @DeleteMapping("/delete/{id}")
    public void deleteLeave(@PathVariable Integer id) {
        if (!leaveRepository.existsById(id)) {
            throw new RuntimeException("Leave not found with id: " + id);
        }
        leaveRepository.deleteById(id);
    }
}
