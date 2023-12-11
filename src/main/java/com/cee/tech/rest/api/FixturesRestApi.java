package com.cee.tech.rest.api;

import com.cee.tech.app.bean.sharedbean.FixtureBeanI;
import com.cee.tech.app.model.entity.BookTicket;
import com.cee.tech.app.model.entity.Fixture;


import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/fixture")
public class FixturesRestApi extends BaseRestApi{

    @EJB(beanName = "userFixtureBean")
    FixtureBeanI fixtureBeanI;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Fixture fixture) {

        fixture = fixtureBeanI.addOrUpdate(fixture);
        return respond();
    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return respond(fixtureBeanI.list(new Fixture()));

    }
}
