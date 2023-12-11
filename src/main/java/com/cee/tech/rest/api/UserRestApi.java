package com.cee.tech.rest.api;

import com.cee.tech.app.bean.userbean.UserBeanI;
import com.cee.tech.app.model.entity.User;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserRestApi extends BaseRestApi{

    @EJB
    UserBeanI userBeanI;



    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return respond(userBeanI.list(new User()));

    }
}
