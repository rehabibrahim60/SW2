package com.example.demo.repository;

import java.util.List;
import com.example.demo.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    boolean existsByTitle(String title);
    Article findByTitle(String title);
    void deleteByTitle(String title);
    List<Article> findAll();
    List<Article> findByTitleContainingIgnoreCase(String title);
}

