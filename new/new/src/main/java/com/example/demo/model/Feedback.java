package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Table(name="feedback")
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="feedback_id")
    private Long feedback_id;
    
    @Column(name="feedback_desc")
    @NotBlank(message = "Please enter your feedback")
    @Size(min = 2 , max = 200, message = "feedback must be between 2:200 letters")
    private String feedback_desc;

    @Column(name="user_id")
    private Long user_id;

    public Long getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(Long feedback_id) {
        this.feedback_id = feedback_id;
    }

    public String getFeedback_desc() {
        return feedback_desc;
    }

    public void setFeedback_desc(String feedback_desc) {
        this.feedback_desc = feedback_desc;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }


    
}
