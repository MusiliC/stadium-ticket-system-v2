package com.cee.tech.rest.api;

import com.cee.tech.app.bean.sharedbean.FixtureBeanI;
import com.cee.tech.app.model.entity.Fixture;


import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/fixture")
public class FixturesRestApi extends BaseRestApi{

    @EJB(beanName = "userFixtureBean")
    FixtureBeanI fixtureBeanI;
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return respond(fixtureBeanI.list(new Fixture()));

    }
}
