package com.example.demo.controller;


import com.example.demo.model.Notification;
import com.example.demo.repository.NotificationRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController

public class NotificationController {

    private final NotificationRepository notificationRepository;

   
    public NotificationController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @PostMapping("/notifications")
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationRepository.save(notification);
    }
}

