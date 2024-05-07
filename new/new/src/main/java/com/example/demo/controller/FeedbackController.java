package com.example.demo.controller;

import com.example.demo.model.Feedback;
import com.example.demo.repository.FeedbackRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin
@RequestMapping("/feedbacks")
public class FeedbackController {

    private final FeedbackRepository feedbackRepository;

   
    public FeedbackController(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @PostMapping("/add")
    public String addFeedback(@RequestParam("user_id") Long user_id,
                              @RequestParam("desc") String feedback_desc) {
        Feedback feedback = new Feedback();
        feedback. setUser_id(user_id);
        feedback.setFeedback_desc(feedback_desc);
        feedbackRepository.save(feedback);
        return "redirect:/"; // Redirect to homepage or any other page

    }

    @GetMapping("/allfeedback")
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        List<Feedback> feedbackList = feedbackRepository.findAll();
        return new ResponseEntity<>(feedbackList, HttpStatus.OK);
}
}

