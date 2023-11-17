package com.cee.tech.app.bean.userbean;

import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.app.model.entity.Ticket;

public interface BookTicketI {
    public  String allTickets();
    public Ticket bookTicket(Ticket ticket) throws  Exception;
    public  void deleteTicket(Ticket ticket);
}
