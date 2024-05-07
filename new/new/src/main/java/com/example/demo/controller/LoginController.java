package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserType;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("/l")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String name, @RequestParam String password , @RequestParam UserType type) {
        Optional<User> userOptional = userRepository.findByName(name);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(password)) {
                switch (type) {
                    case USER:
                        return ResponseEntity.ok("redirect:/view/home");
                    case ADMIN:
                        return ResponseEntity.ok("redirect:/view/admin");
                    case JOURNALIST:
                        return ResponseEntity.ok("redirect:/view/jo");
                    default:
                        return ResponseEntity.badRequest().body("Unknown user type");
                }
            } else {
                return ResponseEntity.badRequest().body("Incorrect password");
            }
        } else {
            return ResponseEntity.badRequest().body("User not found");
        }
    }
}