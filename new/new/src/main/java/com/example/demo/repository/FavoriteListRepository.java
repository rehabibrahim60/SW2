package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.FavoriteList;

public interface FavoriteListRepository extends JpaRepository<FavoriteList , Long>{

}
