package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;





@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        // Save the user based on the type
        switch (user.getType()) {
            case USER:
                userRepository.save(user);
                return ResponseEntity.ok("redirect:/view/home"); // Assuming there's a view mapping for home
            case JOURNALIST:
                userRepository.save(user);
                return ResponseEntity.ok("redirect:/view/jo"); // Assuming there's a view mapping for journalist
            case ADMIN:
                userRepository.save(user);
                return ResponseEntity.ok("redirect:/view/admin"); // Assuming there's a view mapping for admin
            default:
                return ResponseEntity.badRequest().body("Unknown user type");
        }
    }

   @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }



    @PutMapping("/block-user/{user_id}")
public ResponseEntity<String> blockUser(@PathVariable("user_id") Long user_id) {
    Optional<User> optionalUser = userRepository.findById(user_id);
    if (optionalUser.isPresent()) {
        User user = optionalUser.get();
        user.setBlocked(true); // Set user as blocked
        userRepository.save(user);
        return ResponseEntity.ok("User blocked successfully.");
    } else {
        return ResponseEntity.notFound().build();
    }
}


}
