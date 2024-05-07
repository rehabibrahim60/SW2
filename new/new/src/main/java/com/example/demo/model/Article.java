package com.example.demo.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "artical") // Correct the table name if needed
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long art_id;

    @Column(name = "title") // Match the column name in your database
    @NotBlank(message = "Please enter article title")
    @Size(min = 5 , max = 50, message = "title must be between 5:50 letters")
    private String title;
    
    @Column(name = "content") // Match the column name in your database
    @NotBlank(message = "Please enter the content")
    @Size(min = 5 , max = 200, message = "article content must be between 5:200 letters")
    private String content;

    @Column(name = "jo_id") // Match the column name in your database
    private Long jo_id;

     

    // Getters and setters

    
    public Long getArt_id() {
        return art_id;
    }

    public void setArt_id(Long art_id) {
        this.art_id = art_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getJo_id() {
        return jo_id;
    }

    public void setJo_id(Long jo_id) {
        this.jo_id = jo_id;
    }

    
}
