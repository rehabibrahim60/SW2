package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Table(name="journalist")
@Entity
public class Journalist {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jo_id")
    private Long joId;

    @Column(name = "jo_address")
    @NotBlank(message = "Please enter your address")
    @Size(min = 2 , max = 200, message = "address must be between 2:200 letters")
    private String joAddress;

    @Column(name = "jo_name")
    @NotBlank(message = "Please enter your name")
    @Size(min = 2 , max = 30 , message = "name must be between 2:30 letters")
    private String joName;

    @Column(name = "jo_email")
    @Email
    private String joEmail;

    @Column(name = "jo_mobile")
    @Pattern(regexp= "^[0-9]{11}$")
    private String joMobile;

    public Long getJoId() {
        return joId;
    }

    public void setJoId(Long joId) {
        this.joId = joId;
    }

    public String getJoAddress() {
        return joAddress;
    }

    public void setJoAddress(String joAddress) {
        this.joAddress = joAddress;
    }

    public String getJoName() {
        return joName;
    }

    public void setJoName(String joName) {
        this.joName = joName;
    }

    public String getJoEmail() {
        return joEmail;
    }

    public void setJoEmail(String joEmail) {
        this.joEmail = joEmail;
    }

    public String getJoMobile() {
        return joMobile;
    }

    public void setJoMobile(String joMobile) {
        this.joMobile = joMobile;
    }


}
