package com.cee.tech.app.bean.userbean;

import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.model.entity.BookTicket;
import com.cee.tech.utils.TicketNumber;
import com.cee.tech.utils.UserDetails;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

@Stateless
@Remote
public class BookTicketImpl extends GenericBeanImpl<BookTicket> implements BookTicketI {
    @Inject
    @Named("Ticket")
    private TicketNumber ticketNumberGenerator;
  //  @Inject
//    @Named("UserBean")
//    private UserDetails userDetails;




    @Override
    public void addOrUpdate(BookTicket bookTicket) {

        bookTicket.setTicketNumber(ticketNumberGenerator.generate());
        getDao().addOrUpdate(bookTicket);
    }

}
