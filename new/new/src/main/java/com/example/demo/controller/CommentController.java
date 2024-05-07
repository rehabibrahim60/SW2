package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CommentController {

    private final CommentRepository commentRepository;

  
    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PostMapping("/comments")
    public String addComment(@RequestBody Comment comment) {
        commentRepository.save(comment);
        return "Comment added successfully";
    }


    @GetMapping("/allcomments")
    public List<Comment> getAllComments() {
        return commentRepository.findAll(); // Fetch all comments from the database
    }
}

