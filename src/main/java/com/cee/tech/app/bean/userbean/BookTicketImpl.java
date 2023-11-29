package com.cee.tech.app.bean.userbean;

import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.model.entity.BookTicket;
import com.cee.tech.utils.TicketNumber;
import com.cee.tech.utils.UniqueNumber;
import com.cee.tech.utils.UniqueNumberType;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Remote
public class BookTicketImpl extends GenericBeanImpl<BookTicket> implements BookTicketI {
    @Inject
    @UniqueNumber(type = UniqueNumberType.TICKET)
    private TicketNumber ticketNumberGenerator;

    @Override
    public void addOrUpdate(BookTicket bookTicket) {
        bookTicket.setTicketNumber(ticketNumberGenerator.generate());
        getDao().addOrUpdate(bookTicket);
    }

}
