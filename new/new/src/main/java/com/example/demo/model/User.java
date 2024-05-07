package com.example.demo.model;


import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Table(name="user")
@Entity
public class User {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

   @Column(name="name")
    @NotBlank(message = "Please enter your name")
    @Size(min = 2 , max = 30 , message = "name must be between 2:30 letters")
    private String name;

    @Column(name="password")
    @Pattern(regexp = "^[0-9]{5}$")
    private String password;

    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private UserType type;

    @Column(name="gender")
    @Pattern(regexp = "^(male|female)$")
    private String gender;

    @Column(name="email")
    @Email
    private String email;

    @Column(name="blocked")
    private boolean blocked;

     public Long getUser_id() {
        return user_id;
    }
    public boolean isBlocked() {
        return blocked;
    }
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
    public List<FavoriteList> getFavoriteLists() {
        return favoriteLists;
    }
    public void setFavoriteLists(List<FavoriteList> favoriteLists) {
        this.favoriteLists = favoriteLists;
    }
    @OneToMany(mappedBy = "user")
    private List<FavoriteList> favoriteLists = new ArrayList<>();
   
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
   
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Long getId() {
        return user_id;
    }
    public void setId(Long user_id) {
        this.user_id = user_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public UserType getType() {
        return type;
    }
    public void setType(UserType type) {
        this.type = type;
    }

    // Getters and setters



}
