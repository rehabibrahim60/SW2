package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Login;


public interface LoginRepository extends JpaRepository<Login , Long>{

    Optional<Login> findByName(String name);
    Optional<Login> findByPassword(String password);

}