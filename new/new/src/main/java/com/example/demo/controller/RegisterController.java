// package com.example.demo.controller;


// import com.example.demo.model.User;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// // import org.springframework.web.bind.annotation.RequestParam;

// @Controller
// @RequestMapping("/register")
// public class RegisterController {

//     @GetMapping
//     public String showRegistrationForm(Model model) {
//         model.addAttribute("user", new User());
//         return "registration-form";
//     }

//     @PostMapping
//     public String processRegistrationForm(User user, Model model) {
//         // Perform validation and processing logic here
//         // You can use Hibernate Validator or custom validation logic

//         // Example validation
//         if (user.getFirstName().isEmpty()) {
//             model.addAttribute("errorName", "*Your name is empty.");
//             return "registration-form";
//         }

//         // Save user to database or perform other actions
//         // userService.saveUser(user);
//         return "registration-success";
//     }
// }
