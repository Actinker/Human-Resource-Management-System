package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestBody User loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());

        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return user.getRole(); // Return role or a success message
        }
        return "Invalid credentials";
    }

    @GetMapping("/list")
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String adminUsername, @RequestBody User newUser) {
        User admin = userRepository.findByUsername(adminUsername);
        if (admin != null && "ADMIN".equals(admin.getRole())) {
            // Check if username already exists
            if (userRepository.findByUsername(newUser.getUsername()) != null) {
                return "Username already exists";
            }
            userRepository.save(newUser);
            return "User added successfully";
        }
        return "Access Denied";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@RequestParam String adminUsername, @PathVariable Long id) {
        User admin = userRepository.findByUsername(adminUsername);
        if (admin != null && "ADMIN".equals(admin.getRole())) {
            // Don't allow admin to delete themselves
            if (admin.getId().equals(id)) {
                return "Cannot delete your own account";
            }
            userRepository.deleteById(id);
            return "User deleted successfully";
        }
        return "Access Denied";
    }
}
