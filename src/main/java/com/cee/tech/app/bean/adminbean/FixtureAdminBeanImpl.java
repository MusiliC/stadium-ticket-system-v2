package com.cee.tech.app.bean.adminbean;

import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.bean.sharedbean.FixtureBeanI;
import com.cee.tech.app.model.entity.Audit;
import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.app.model.entity.FixtureType;
import com.cee.tech.app.model.entity.TicketManagement;
import com.cee.tech.database.Database;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;



@Stateless(name = "adminFixtureBean")
@Remote
public class FixtureAdminBeanImpl extends GenericBeanImpl<Fixture> implements FixtureBeanI {
    @Inject
    private Event<Audit> logger;

    @Override
    public Fixture addOrUpdate(Fixture fixture) {


        if (fixture.getFixtureDescId() == 0)
            throw new RuntimeException("Fixture type id not found");

        TicketManagement ticketManagement = getDao().getEm().find(TicketManagement.class, fixture.getFixtureDescId());

        if (ticketManagement == null)
            throw new RuntimeException("Invalid fixture type details");

        fixture.setTicketManagement(ticketManagement);

        Audit log = new Audit();
        log.setLogdetails("Fixture created at: " + DateFormat.getDateTimeInstance().format(new Date()) + ", " + fixture.getFixtureLocation());

        logger.fire(log);

       return getDao().addOrUpdate(fixture);


    }


}
