package com.mailsender.MailSender.Controller;

import com.mailsender.MailSender.Model.Email;
import com.mailsender.MailSender.Service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody Email email) {
        try {
            emailService.sendEmail(email);
            return "Email sent successfully!";
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
            return "Error sending email: " + e.getMessage();
        }
    }
}
