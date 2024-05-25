package com.example.messaging;

import java.time.LocalDateTime;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
    private final JmsTemplate jmsTemplate;

    public MessageSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Scheduled(fixedRate = 1000)
    public void sendTime() {
        var msg = "Current Date & Time is: " + LocalDateTime.now();
        jmsTemplate.convertAndSend("time-queue", msg);
    }
}
