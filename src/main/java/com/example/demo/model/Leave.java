/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDate;
/**
 *
 * @author abina
 */
@Entity
@Table(name="leaves")
public class Leave {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;
    
    @Column(name="leave_date",nullable=false)
    private LocalDate leaveDate;
    
    @Column(columnDefinition="text")
    private String remarks;

    @Column(name = "halfday_yn", length = 1, nullable = false)
    private char halfdayYN = 'N'; // default 'N'

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(LocalDate leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public char getHalfdayYN() {
        return halfdayYN;
    }

    public void setHalfdayYN(char halfdayYN) {
        if (halfdayYN == 'Y' || halfdayYN == 'N') {
            this.halfdayYN = halfdayYN;
        } else {
            throw new IllegalArgumentException("halfdayYN must be 'Y' or 'N'");
        }
    }
}
