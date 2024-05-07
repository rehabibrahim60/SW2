package com.example.demo.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;

    @Column(name = "comment")
    @NotBlank(message = "Please enter your comment")
    @Size(min = 2 , max = 200, message = "comment must be between 2:200 letters")
    private String comment;

    @Column(name = "u_name")
    @NotBlank(message = "Please enter your name")
    @Size(min = 2 , max = 200, message = "name must be between 2:200 letters")
    private String userName;

    public Comment() {
        // Default constructor required by JPA
    }

    // Getters and setters
    public Long getCommentId() {
        return comment_id;
    }

    public void setCommentId(Long comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
