package com.ex.dm.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {

    @PostMapping
    public String sendNotification(@RequestBody Map<String, Object> notification) {
        System.out.println("📢 Sending Notification: " + notification);
        return "Notification Sent!";
    }
}

