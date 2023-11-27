package com.cee.tech.app.bean.userbean;

import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.model.entity.BookTicket;


public class BookTicketImpl extends GenericBeanImpl<BookTicket> implements BookTicketI {
    @Override
    public String allTickets() {
        return null;
    }

    @Override
    public BookTicket bookTicket(BookTicket ticket) throws Exception {
        return null;
    }

    @Override
    public void deleteTicket(BookTicket ticket) {
        System.out.println("deleted");
    }
}
