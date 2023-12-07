package com.cee.tech.app.bean.userbean;

import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.model.entity.Audit;
import com.cee.tech.app.model.entity.BookTicket;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.utils.TicketNumber;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import java.text.DateFormat;
import java.util.Date;

@Stateless
@Remote
public class BookTicketImpl extends GenericBeanImpl<BookTicket> implements BookTicketI {
    @Inject
    @Named("Ticket")
    private TicketNumber ticketNumberGenerator;

    @Inject
    private Event<Audit> logger;

    @PostConstruct
    public void init(){
        System.out.println("Bean has bean created!!");
    }


    @Override
    public void addOrUpdate(BookTicket bookTicket) {

        if(bookTicket == null)
            throw  new RuntimeException("Invalid ticket details");

        if(bookTicket.getUserId() == 0)
            throw  new RuntimeException("User id not found");

        User user = getDao().getEm().find(User.class, bookTicket.getUserId());

        if(user == null)
            throw  new RuntimeException("Invalid user details");

        bookTicket.setUser(user);

        bookTicket.setTicketNumber(ticketNumberGenerator.generate());
        getDao().addOrUpdate(bookTicket);

        //firing event to send an email
        Audit log = new Audit();
        log.setLogdetails("Confirmed you booked ticket: " + DateFormat.getDateTimeInstance().format(new Date()) + ", " + bookTicket.getEmail());

        logger.fire(log);
    }

}
