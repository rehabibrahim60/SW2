package com.example.demo.repository;

import java.util.List;


import com.example.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // You can define custom query methods here if needed
    List<Comment> findAll();
}
