package com.cee.tech.app.bean.userbean;

import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.bean.adminbean.AdminTicketManagementI;
import com.cee.tech.app.bean.sharedbean.FixtureBeanI;
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
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Stateless
@Remote
public class BookTicketImpl extends GenericBeanImpl<BookTicket> implements BookTicketI {

    @EJB
    UserBeanI userBeanI;

    @EJB
    AdminTicketManagementI adminTicketManagementI;

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


        if (bookTicket.getFixtureId() == 0)
            throw new RuntimeException("Fixture id not found");

        User user = getDao().getEm().find(User.class, bookTicket.getUserId());

        Fixture fixture = getDao().getEm().find(Fixture.class, bookTicket.getFixtureId());


        if (user == null)
            throw new RuntimeException("Invalid user details");


        if (fixture == null)
            throw new RuntimeException("Invalid fixture details");


        //calling ticket desc
        TicketManagement ticketManagementDesc = getDao().getEm().find(TicketManagement.class, fixture.getFixtureDescId());
        if (ticketManagementDesc == null)
            throw new RuntimeException("Invalid fixture desc details");

        int totalTicketsForFixture = ticketManagementDesc.getTotalTickets();
        int totalVIPTickets = ticketManagementDesc.getTotalVip();
        int totalVIPTicketsSold = ticketManagementDesc.getTotalVipTicketsSold();
        int totalNormalTickets = ticketManagementDesc.getTotalNormal();
        int totalNormalTicketsSold = ticketManagementDesc.getTotalNormalTicketsSold();

        if (bookTicket.getTicketType().equals(TicketType.VIP)) {
            totalTicketsForFixture = totalTicketsForFixture - bookTicket.getTotalTickets();
            totalVIPTickets = totalVIPTickets - bookTicket.getTotalTickets();
            totalVIPTicketsSold = totalVIPTicketsSold + bookTicket.getTotalTickets();
            ticketManagementDesc.setTotalTickets(totalTicketsForFixture);
            ticketManagementDesc.setTotalVip(totalVIPTickets);
            ticketManagementDesc.setTotalVipTicketsSold(totalVIPTicketsSold);
        }

        if (bookTicket.getTicketType().equals(TicketType.NORMAL)) {
            totalTicketsForFixture = totalTicketsForFixture - bookTicket.getTotalTickets();
            totalNormalTickets  = totalNormalTickets - bookTicket.getTotalTickets();
            totalNormalTicketsSold  = totalNormalTicketsSold  + bookTicket.getTotalTickets();
            ticketManagementDesc.setTotalTickets(totalTicketsForFixture);
            ticketManagementDesc.setTotalNormal(totalNormalTickets);
            ticketManagementDesc.setTotalNormalTicketsSold(totalNormalTicketsSold);
        }

        bookTicket.setUser(user);
        bookTicket.setFixture(fixture);

        bookTicket.setTicketNumber(ticketNumberGenerator.generate());

        //firing event to send an email
        Audit log = new Audit();
        log.setLogdetails("Confirmed you booked ticket: " + DateFormat.getDateTimeInstance().format(new Date()) + ", " + bookTicket.getTicketNumber());

        logger.fire(log);

        if (bookTicket.getTicketType().equals(TicketType.VIP)) {
            int newVipTicketCount = user.getVipTickets() + bookTicket.getTotalTickets();
            user.setVipTickets(newVipTicketCount);
            bookTicket.setUser(userBeanI.addOrUpdate(user));
        }

        if (bookTicket.getTicketType().equals(TicketType.NORMAL)) {
            int newNormalTicketCount = user.getNormalTickets() + bookTicket.getTotalTickets();
            user.setNormalTickets(newNormalTicketCount);
            bookTicket.setUser(userBeanI.addOrUpdate(user));
        }

        //testing native query
        List<Object[]> tickets = getDao().nativeQuery("select t.ticketNumber, f.fixtureType, f.homeTeam, f.awayTeam, f.fixtureDate " +
                " from bookTicket t inner join fixtures f on t.ticket_fixture_desc = f.id");

        for (Object[] ticket : tickets) {
            System.out.println();
            System.out.println("*********************************");
            System.out.println(Arrays.toString(ticket));
            System.out.println();
            System.out.println("*********************************");
        }

        getDao().getEm().flush();

        return getDao().addOrUpdate(bookTicket);

    }


    @Override
    public List<BookTicket> list(Object entity) {
        return em.createQuery("FROM BookTicket t",BookTicket.class).getResultList() ;
    }

    //query to join bookTicket with ticketDesc through fixture table
    //select t.ticket_fixture_desc, t.ticketNumber, f.fixtureType, f.homeTeam, f.awayTeam, f.fixtureDate, d.totalTickets from bookTicket t left  join fixtures f  on t.ticket_fixture_desc = f.id  join ticketManagement d on f.fixture_desc_id = d.id

}