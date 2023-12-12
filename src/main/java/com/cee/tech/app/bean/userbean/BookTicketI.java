package com.cee.tech.app.bean.userbean;

import com.cee.tech.app.bean.GenericBeanI;
import com.cee.tech.app.model.entity.BookTicket;

import java.util.List;


public interface BookTicketI extends GenericBeanI<BookTicket> {

    List<BookTicket> findAllTicketsByUser(int userId);

}
