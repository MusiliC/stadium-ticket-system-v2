package com.cee.tech.app.bean.userbean;

import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.bean.sharedbean.UserBeanImpl;
import com.cee.tech.app.model.entity.*;
import com.cee.tech.utils.TicketNumber;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Stateless
@Remote
public class BookTicketImpl extends GenericBeanImpl<BookTicket> implements BookTicketI {

    @EJB
    UserBeanI userBeanI;
    @Inject
    @Named("Ticket")
    private TicketNumber ticketNumberGenerator;

    @Inject
    private Event<Audit> logger;

    @PostConstruct
    public void init() {
        System.out.println("Bean has bean created!!");
    }

    @PersistenceContext
    EntityManager em;


    @Override
    public BookTicket addOrUpdate(BookTicket bookTicket) {

        if (bookTicket == null)
            throw new RuntimeException("Invalid ticket details");

        if (bookTicket.getUserId() == 0)
            throw new RuntimeException("User id not found");

        User user = getDao().getEm().find(User.class, bookTicket.getUserId());

        if (user == null)
            throw new RuntimeException("Invalid user details");

        bookTicket.setUser(user);

        bookTicket.setTicketNumber(ticketNumberGenerator.generate());

        //firing event to send an email
        Audit log = new Audit();
        log.setLogdetails("Confirmed you booked ticket: " + DateFormat.getDateTimeInstance().format(new Date()) + ", " + bookTicket.getTicketNumber());

        logger.fire(log);

        if(bookTicket.getTicketType().equals(TicketType.VIP)) {
            int newVipTicketCount = user.getVipTickets() + bookTicket.getTotalTickets();
            user.setVipTickets(newVipTicketCount);
            bookTicket.setUser(userBeanI.addOrUpdate(user));
        }

        if(bookTicket.getTicketType().equals(TicketType.NORMAL)) {
            int newNormalTicketCount = user.getNormalTickets() + bookTicket.getTotalTickets();
            user.setNormalTickets(newNormalTicketCount);
            bookTicket.setUser(userBeanI.addOrUpdate(user));
        }

        getDao().getEm().flush();

        return getDao().addOrUpdate(bookTicket);

    }

    @Override
    public List<BookTicket> list(Object entity) {
        return em.createQuery("FROM BookTicket t", BookTicket.class).getResultList();
    }

}
