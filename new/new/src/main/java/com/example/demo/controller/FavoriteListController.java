package com.example.demo.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Article;
import com.example.demo.model.FavoriteList;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.FavoriteListRepository;

@CrossOrigin
@RestController
@RequestMapping("/favorite-lists")

public class FavoriteListController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private FavoriteListRepository favoriteListRepository;


   // Add an article to a favorite list
   @PostMapping("/{listId}/articles/{articleId}")
   public ResponseEntity<FavoriteList> addArticleToList(@PathVariable Long listId, @PathVariable Long articleId) {
       Optional<FavoriteList> optionalList = favoriteListRepository.findById(listId);
       Optional<Article> optionalArticle = articleRepository.findById(articleId);

       if (optionalList.isPresent() && optionalArticle.isPresent()) {
           FavoriteList list = optionalList.get();
           Article article = optionalArticle.get();

           // Add article to list
           list.getArticles().add(article);
           favoriteListRepository.save(list);

           return ResponseEntity.ok(list);
       } else {
           return ResponseEntity.notFound().build();
       }
   }


    @DeleteMapping("/{listId}/articles/{articleId}")
    public ResponseEntity<FavoriteList> removeArticleFromList(@PathVariable Long listId, @PathVariable Long articleId) {
        Optional<FavoriteList> optionalList = favoriteListRepository.findById(listId);
        Optional<Article> optionalArticle = articleRepository.findById(articleId);

        if (optionalList.isPresent() && optionalArticle.isPresent()) {
            FavoriteList list = optionalList.get();
            Article article = optionalArticle.get();

            // Remove article from list
            list.getArticles().remove(article);
            favoriteListRepository.save(list);

            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
