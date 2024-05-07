package com.example.demo.controller;


import com.example.demo.model.Advertisement;
import com.example.demo.model.Notification;
import com.example.demo.repository.AdvertisementRepository;
import com.example.demo.repository.NotificationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@CrossOrigin
@Controller


public class HomeController {

    private final AdvertisementRepository advertisementRepository;
    private final NotificationRepository notificationRepository;

   
    public HomeController(AdvertisementRepository advertisementRepository, NotificationRepository notificationRepository) {
        this.advertisementRepository = advertisementRepository;
        this.notificationRepository = notificationRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Advertisement> advertisements = advertisementRepository.findAll();
        model.addAttribute("advertisements", advertisements);

        List<Notification> notifications = notificationRepository.findAll();
        model.addAttribute("notifications", notifications);

        return "home"; // Assuming you have a Thymeleaf template named "home.html" in your resources/templates directory
    }
}

