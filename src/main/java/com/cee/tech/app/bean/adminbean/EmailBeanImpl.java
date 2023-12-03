package com.cee.tech.app.bean.adminbean;

import com.cee.tech.app.model.entity.Audit;
import com.cee.tech.app.model.entity.BookTicket;

import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import java.io.Serializable;

@Singleton
public class EmailBeanImpl implements Serializable {
    public void email(@Observes BookTicket bookTicket){
        System.out.println("Email functionality");
    }
}
