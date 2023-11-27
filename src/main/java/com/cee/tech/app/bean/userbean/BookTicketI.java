package com.cee.tech.app.bean.userbean;

import com.cee.tech.app.bean.GenericBeanI;
import com.cee.tech.app.model.entity.BookTicket;


public interface BookTicketI extends GenericBeanI<BookTicket> {
    public  String allTickets();
    public BookTicket bookTicket(BookTicket ticket) throws  Exception;
    public  void deleteTicket(BookTicket ticket);
}
