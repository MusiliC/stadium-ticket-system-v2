package com.cee.tech.app.bean.userbean;

import com.cee.tech.app.model.entity.BookTicket;


public interface BookTicketI {
    public  String allTickets();
    public BookTicket bookTicket(BookTicket ticket) throws  Exception;
    public  void deleteTicket(BookTicket ticket);
}
