package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "admin_email")
    @Email
    private String adminEmail;

    @Column(name = "admin_name")
    @NotBlank(message = "Please enter your name")
    @Size(min = 2 , max = 30 , message = "name must be between 2:30 letters")
    private String adminName;

    @Column(name = "admin_address")
    @NotBlank(message = "Please enter your address")
    @Size(min = 5 , max = 50, message = "address must be between 2:50 letters")
    private String adminAddress;

    @Column(name = "admin_mobile")
    @Pattern(regexp= "^[0-9]{11}$")
    private String adminMobile;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }

    public String getAdminMobile() {
        return adminMobile;
    }

    public void setAdminMobile(String adminMobile) {
        this.adminMobile = adminMobile;
    }

    // Constructors, getters, and setters

    
}

