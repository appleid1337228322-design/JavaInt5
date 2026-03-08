
package com.example.notification.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

 private final JavaMailSender mailSender;

 public EmailService(JavaMailSender mailSender) {
  this.mailSender = mailSender;
 }

 public void sendCreate(String email) {

  SimpleMailMessage message = new SimpleMailMessage();
  message.setTo(email);
  message.setSubject("Account created");
  message.setText("Здравствуйте! Ваш аккаунт на сайте был успешно создан.");

  mailSender.send(message);
 }

 public void sendDelete(String email) {

  SimpleMailMessage message = new SimpleMailMessage();
  message.setTo(email);
  message.setSubject("Account deleted");
  message.setText("Здравствуйте! Ваш аккаунт был удалён.");

  mailSender.send(message);
 }
}
