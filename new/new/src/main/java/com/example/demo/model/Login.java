package com.example.demo.model;

import jakarta.persistence.*;

@Table(name="login")
@Entity
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="login_id")
    private Long login_id;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private UserType type;

    public Long getLogin_id() {
        return login_id;
    }

    public void setLogin_id(Long login_id) {
        this.login_id = login_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    

}
