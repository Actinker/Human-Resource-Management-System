package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "states")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    // Getters only (no setters needed if read-only)
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
