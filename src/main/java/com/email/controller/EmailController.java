package com.email.controller;
import com.email.entity.Email;
import com.email.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody Email email){
        emailService.sendEmail(email);
        return new ResponseEntity<>( "Email sent successfully!", HttpStatus.CREATED);
    }
}
