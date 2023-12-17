package com.cee.tech.api.rest.endpoints;

import com.cee.tech.app.bean.adminbean.AdminTicketManagementI;
import com.cee.tech.app.model.entity.TicketManagement;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ticketmanagement")
public class TicketManagementRestApi extends BaseRestApi {

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

    @Path("/update/{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, TicketManagement ticketManagement) {
        ticketManagement = ticketManagementI.addOrUpdate(ticketManagement);
        return respond();
    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return respond(ticketManagementI.list(new TicketManagement()));
    }

    @Path("/update/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchById(@PathParam("id") int id) {
        TicketManagement ticketManagement = ticketManagementI.selectSingle(TicketManagement.class, id);
        return respond(ticketManagement);
    }

    @Path("/delete/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        ticketManagementI.delete(TicketManagement.class, id);
        return respond();
    }
}
