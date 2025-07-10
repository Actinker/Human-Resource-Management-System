package com.example.demo.controller;

import com.example.demo.model.State;
import com.example.demo.repository.StateRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {

    private final StateRepository stateRepository;

    public StateController(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @GetMapping("/list")
    public List<State> getAllStates() {
        return stateRepository.findAll();
    }
}
