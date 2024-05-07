package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Journalist;

public interface journalistRepository extends JpaRepository<Journalist , Long> {

}
