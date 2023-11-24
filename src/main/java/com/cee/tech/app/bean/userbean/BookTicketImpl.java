package com.cee.tech.app.bean.userbean;

import com.cee.tech.app.bean.userbean.BookTicketI;
import com.cee.tech.app.model.entity.Ticket;

import javax.ejb.Stateless;


public class BookTicketImpl implements BookTicketI {
    @Override
    public String allTickets() {
        return null;
    }

    @Override
    public Ticket bookTicket(Ticket ticket) throws Exception {
        return null;
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        System.out.println("deleted");
    }
}
