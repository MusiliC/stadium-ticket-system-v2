package com.cee.tech.rest.api;

import com.cee.tech.app.bean.userbean.BookTicketI;
import com.cee.tech.app.model.entity.BookTicket;

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


    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return respond(bookTicketI.list(new BookTicket()));

    }
}
