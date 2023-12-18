package com.cee.tech.app.mail;

import com.cee.tech.app.model.entity.Mail;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Singleton
@Remote
public class EmailSessionImplementation implements EmailSessionBeanI {

    private static final String FROM_EMAIL = "musili014@outlook.com";
    private static final String PASSWORD = "musili@254";
    private static final String SMTP_HOST = "smtp.office365.com";
    private static final String SMTP_PORT = "587";
    private Session session;

    @PostConstruct
    public void init() {
        Properties properties = new Properties();

        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.port", SMTP_PORT);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create session
        session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
            }
        });
    }

    @Override
    public void sendMail(Mail mail) {
        Message message = new MimeMessage(session);
        try {
            // Create message

            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail.getRecipient()));
            message.setSubject(mail.getSubject());
            message.setText(mail.getMessage());
            // Send message
            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
