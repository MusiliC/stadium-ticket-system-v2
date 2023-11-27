package com.cee.tech.app.bean.userbean;

import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.model.entity.BookTicket;
import com.cee.tech.utils.TicketNumberGenerator;

import javax.inject.Inject;


public class BookTicketImpl extends GenericBeanImpl<BookTicket> implements BookTicketI {
    @Inject
    private TicketNumberGenerator ticketNumberGenerator;

    @Override
    public void addOrUpdate(BookTicket bookTicket) {
        bookTicket.setTicketNumber(ticketNumberGenerator.generate());
        getDao().addOrUpdate(bookTicket);
    }

}
