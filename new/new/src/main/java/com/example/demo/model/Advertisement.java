package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;


@Entity
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adv_id;

    @NotBlank(message = "Please enter the title")
    @Size(min = 5 , max = 50, message = "title must be between 5:50 letters")
    private String adv_title;

    @NotBlank(message = "Please enter the description")
    @Size(min = 5 , max = 200, message = "description must be between 5:200 letters")
    private String adv_desc;
    
    public Long getAdv_id() {
        return adv_id;
    }
    public void setAdv_id(Long adv_id) {
        this.adv_id = adv_id;
    }
    public String getAdv_title() {
        return adv_title;
    }
    public void setAdv_title(String adv_title) {
        this.adv_title = adv_title;
    }
    public String getAdv_desc() {
        return adv_desc;
    }
    public void setAdv_desc(String adv_desc) {
        this.adv_desc = adv_desc;
    }
    

}
