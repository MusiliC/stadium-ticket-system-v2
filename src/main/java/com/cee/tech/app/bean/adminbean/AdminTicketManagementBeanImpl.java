package com.cee.tech.app.bean.adminbean;

import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.model.entity.TicketManagement;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote
public class AdminTicketManagementBeanImpl extends GenericBeanImpl<TicketManagement> implements AdminTicketManagementI {
    @Override
    public void addOrUpdate(TicketManagement ticketManagement){
        getDao().addOrUpdate(ticketManagement);
    }
}
