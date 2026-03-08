
package com.example.notification.kafka;

import com.example.notification.service.EmailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventConsumer {

 private final EmailService emailService;

 public UserEventConsumer(EmailService emailService) {
  this.emailService = emailService;
 }

 @KafkaListener(topics = "user-events", groupId = "notification-group")
 public void listen(String message) {

  if (message.contains("CREATE")) {
   emailService.sendCreate(message.split(":")[1]);
  }

  if (message.contains("DELETE")) {
   emailService.sendDelete(message.split(":")[1]);
  }

 }
}
