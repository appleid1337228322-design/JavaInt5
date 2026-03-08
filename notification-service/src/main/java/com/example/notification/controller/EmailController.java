
package com.example.notification.controller;

import com.example.notification.service.EmailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class EmailController {

 private final EmailService emailService;

 public EmailController(EmailService emailService) {
  this.emailService = emailService;
 }

 @PostMapping("/create")
 public void create(@RequestParam String email) {
  emailService.sendCreate(email);
 }

 @PostMapping("/delete")
 public void delete(@RequestParam String email) {
  emailService.sendDelete(email);
 }
}
