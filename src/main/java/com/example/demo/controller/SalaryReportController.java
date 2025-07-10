package com.example.demo.controller;

import com.example.demo.repository.SalaryReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salary")
public class SalaryReportController {

    @Autowired
    private SalaryReportRepository salaryReportRepository;

    @GetMapping("/report")
    public ResponseEntity<String> getSalaryReport(
            @RequestParam int month,
            @RequestParam int year) {
        String reportJson = salaryReportRepository.getSalaryReport(month, year);
        return ResponseEntity.ok(reportJson);
    }
}
