package com.cee.tech.api.rest.endpoints;

import com.cee.tech.app.bean.userbean.UserBeanI;
import com.cee.tech.app.model.entity.BookTicket;
import com.cee.tech.app.model.entity.User;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

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

    @Path("/register")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(User user) {
        try {
            userBeanI.registerUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return respond();
    }
}
