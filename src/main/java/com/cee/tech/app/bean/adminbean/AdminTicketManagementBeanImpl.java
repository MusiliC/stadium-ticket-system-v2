package com.cee.tech.app.bean.adminbean;

import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.model.entity.TicketManagement;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Remote
public class AdminTicketManagementBeanImpl extends GenericBeanImpl<TicketManagement> implements AdminTicketManagementI {
    @PersistenceContext
    EntityManager em;
    @Override
    public void addOrUpdate(TicketManagement ticketManagement){
        getDao().addOrUpdate(ticketManagement);
    }

    @Override
    public List<TicketManagement> list(Object entity) {
        return em.createQuery("FROM TicketManagement t",TicketManagement.class).getResultList() ;
    }
}
