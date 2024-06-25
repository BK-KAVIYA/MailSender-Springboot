package com.mailsender.MailSender.Service;

import com.mailsender.MailSender.Model.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${myapp.email.from}")
    private String from;

    public void sendEmail(Email email) throws MessagingException, IOException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // Load the HTML template
        Path path = Paths.get(new ClassPathResource("templates/email-template.html").getURI());
        String htmlContent = new String(Files.readAllBytes(path));

        helper.setFrom(from);
        helper.setTo(email.getTo());
        helper.setSubject(email.getSubject());
        helper.setText(htmlContent, true); // true indicates HTML content

        mailSender.send(message);
    }
}
