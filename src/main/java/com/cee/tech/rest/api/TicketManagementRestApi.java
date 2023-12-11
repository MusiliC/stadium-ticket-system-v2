package com.cee.tech.rest.api;

import com.cee.tech.app.bean.adminbean.AdminTicketManagementI;
import com.cee.tech.app.bean.sharedbean.FixtureBeanI;
import com.cee.tech.app.model.entity.BookTicket;
import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.app.model.entity.TicketManagement;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ticketmanagement")
public class TicketManagementRestApi extends BaseRestApi{

    @EJB
    AdminTicketManagementI ticketManagementI;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(TicketManagement ticketManagement) {

        ticketManagement = ticketManagementI.addOrUpdate(ticketManagement);
        return respond();
    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return respond(ticketManagementI.list(new TicketManagement()));
    }
}
