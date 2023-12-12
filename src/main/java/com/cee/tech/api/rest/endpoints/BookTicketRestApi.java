package com.cee.tech.api.rest.endpoints;

import com.cee.tech.app.bean.userbean.BookTicketI;
import com.cee.tech.app.model.entity.BookTicket;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bookticket")
public class BookTicketRestApi extends BaseRestApi{

    @EJB
    private BookTicketI bookTicketI;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(BookTicket bookTicket) {

        bookTicket = bookTicketI.addOrUpdate(bookTicket);
        return respond();
    }

    @RolesAllowed("LOGGED_IN")
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return respond(bookTicketI.list(new BookTicket()));
    }

    @Path("/{ticketId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchById(@PathParam("ticketId") int ticketId) {
       BookTicket ticket = bookTicketI.selectSingle(BookTicket.class, ticketId);
        return respond(ticket);
    }

    @Path("/delete/{ticketId}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("ticketId") int ticketId) {
        bookTicketI.delete(BookTicket.class, ticketId);
        return respond();
    }

}
