package com.example.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notf_id;

    @Column(name = "title")
    private String notf_title;

    @Column(name = "message")
    private String message;

    public Notification() {
        // Default constructor required by JPA
    }

    // Getters and setters
    public Long getNotfId() {
        return notf_id;
    }

    public void setNotfId(Long notf_id) {
        this.notf_id = notf_id;
    }

    public String getNotfTitle() {
        return notf_title;
    }

    public void setNotfTitle(String notf_title) {
        this.notf_title = notf_title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

