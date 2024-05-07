package com.example.demo.repository;



import com.example.demo.model.User;

import java.util.Optional;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
    Optional<User> findByPassword(String password);
    Optional<User> findById(Long user_id);
    Boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    List<User> findAll();
}

