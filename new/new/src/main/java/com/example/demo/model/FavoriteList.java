package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;


@Entity
@Table(name="favorite list")
public class FavoriteList {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="fav_list_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "fav_list_art",
            joinColumns = @JoinColumn(name = "fav_list_id"),
            inverseJoinColumns = @JoinColumn(name = "art_id")
    )

    private List<Article> articles = new ArrayList<>();

    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
