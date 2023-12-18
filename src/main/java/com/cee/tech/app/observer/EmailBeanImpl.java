package com.cee.tech.app.observer;

import com.cee.tech.app.mail.EmailSessionBeanI;
import com.cee.tech.app.model.entity.Audit;
import com.cee.tech.app.model.entity.BookTicket;
import com.cee.tech.app.model.entity.Mail;
import com.cee.tech.app.model.entity.User;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.io.Serializable;

@Singleton
@ApplicationScoped
public class EmailBeanImpl implements Serializable {
    @EJB
    EmailSessionBeanI emailSessionBean;

    public void afterBookTicket(@Observes User user) {
        System.out.println("*************Email event fired***********");
        System.out.println("Useremail is " + user.getUsername());
        Mail mail = new Mail();
        mail.setRecipient(user.getUsername());
        mail.setSubject("Eticket System");
        mail.setMessage("Confirmed you have booked ticket,  This is your ticket number: " );

        emailSessionBean.sendMail(mail);

    }
}
