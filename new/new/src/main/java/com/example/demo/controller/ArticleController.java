
package com.example.demo.controller;


import com.example.demo.Service.ArticleService;
import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;

import jakarta.transaction.Transactional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private final ArticleService articleService;

    @Autowired
    private ArticleRepository articleRepository;

    
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @PostMapping("/add")
    public String addArticle(@RequestParam String title,
                             @RequestParam String content,
                             @RequestParam Long jo_id) {
        return articleService.addArticle(title, content, jo_id);
    }

    @PutMapping("/update")
    public String updateArticle(@RequestParam String title,
                                @RequestParam String content,
                                @RequestParam Long jo_id) {
        return articleService.updateArticle(title, content, jo_id);
    }

    @Transactional
    @DeleteMapping("/delete")
    public String deleteArticle(@RequestParam String title) {
        return articleService.deleteArticle(title);
    }
    @PostMapping("/search")
    public ResponseEntity<List<Article>> searchByTitle(@RequestParam("title") String title) {
        List<Article> articles = articleRepository.findByTitleContainingIgnoreCase(title);
        return ResponseEntity.ok(articles);
    }

@GetMapping("/all")
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        return ResponseEntity.ok(articles);
    }
}