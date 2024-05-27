package com.example.messaging.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.messaging.service.JmsSenderService;

@RestController
public class JmsController {

    private final JmsSenderService jmsSenderService;

    public JmsController(JmsSenderService jmsSenderService) {
        this.jmsSenderService = jmsSenderService;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        jmsSenderService.sendMessage("test-queue", message);
        return "Message sent: " + message;
    }
}
