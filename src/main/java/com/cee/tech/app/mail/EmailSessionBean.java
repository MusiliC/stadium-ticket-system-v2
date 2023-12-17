package com.cee.tech.app.mail;

import com.cee.tech.app.model.entity.Mail;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Stateless
@Remote

public class EmailSessionBean implements EmailSessionBeanI {

    private final int port = 587;
    private final String host = "smtp.office365.com";

    private final String from = "email@gmail.com";
    private final boolean auth = true;
    private Session session;
    private final String password = "password";
    private final String username = "username";
    private final boolean debug = true;

    public void MailBean(){

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", auth);

        props.put("mail.smtp.ssl.enable", true);

        this.session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        session.setDebug(debug);

    }

    @Override
    public void sendMail(Mail mail) {

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(mail.getRecipient())};
            InternetAddress[] replyToEmail = {new InternetAddress(from)};

            message.setRecipients(Message.RecipientType.TO, address);
            message.setReplyTo(replyToEmail);
            message.setSubject(mail.getSubject());
            message.setSentDate(new Date());
            message.setContent(mail.getMessage(),"text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
}
