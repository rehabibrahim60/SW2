package com.example.demo.Service;


import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

  
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public String addArticle(String title, String content, Long joId) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setJo_id(joId);
        articleRepository.save(article);
        return "Article added successfully";
    }

    public String updateArticle(String title, String content, Long joId) {
        if (articleRepository.existsByTitle(title)) {
            Article article = articleRepository.findByTitle(title);
            article.setContent(content);
            article.setJo_id(joId);
            articleRepository.save(article);
            return "Article updated successfully";
        } else {
            return "Article with title '" + title + "' not found";
        }
    }

    public String deleteArticle(String title) {
        if (articleRepository.existsByTitle(title)) {
            articleRepository.deleteByTitle(title);
            return "Article deleted successfully";
        } else {
            return "Article with title '" + title + "' not found";
        }
    }
}

