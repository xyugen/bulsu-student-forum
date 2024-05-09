package com.pagzone.service;

import com.pagzone.props.AppConfig;
import com.sanctionco.jmail.JMail;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Arias
 */
public class EmailService {
    private Mailer mailer;
    private final String emailUsername = AppConfig.getProperty("email.username");;
    private final String emailPassword = AppConfig.getProperty("email.password");;
    
    public EmailService() {
        mailer = MailerBuilder
                    .withSMTPServer("smtp.gmail.com", 587, emailUsername, emailPassword)
                    .buildMailer();
    }
    
    public void sendOTPMail(String toEmail, String authCode) {
        boolean isEmailValid = JMail.strictValidator()
                .isValid(toEmail);
        
        if (isEmailValid) {
            String emailTemplate = """
                <p>Hello,</p>

                <p>Thank you for registering with BulSU Student Forum. To complete your registration, please verify your email address by entering the following authentication code:</p>

                <div style="padding: 6px; background-color: #f0f0f0; border-radius: 5px; display: inline-block;">
                    <code style="font-size: 18px; color: #333;"><strong>%s</strong></code>
                </div>

                <p>If you did not register for an account on BulSU Student Forum, you can ignore this email.</p>

                <p>Thank you,
                <p>BulSU Student Forum Team</p>
                """;

            String formattedEmail = String.format(emailTemplate, authCode);
            Email email = EmailBuilder.startingBlank()
                    .from("BulSU Student Forum", emailUsername)
                    .to(toEmail)
                    .withSubject("Verify Your Email Address")
                    .withHTMLText(formattedEmail)
                    .buildEmail();

            mailer.sendMail(email);
            System.out.println("OTP email sent.");
        } else {
            System.out.println("OTP email can't be sent.");
        }
    }
}
