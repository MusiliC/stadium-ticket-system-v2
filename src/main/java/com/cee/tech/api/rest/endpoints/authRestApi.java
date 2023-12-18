package com.cee.tech.api.rest.endpoints;

import com.cee.tech.app.bean.sharedbean.AuthBeanI;
import com.cee.tech.app.model.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/auth")
public class authRestApi {
    @EJB
    AuthBeanI authBeanI;

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(User user) {
        String jwt;
        String username;
        try {
            User newUser = authBeanI.authenticateUser(user);

            SecretKey key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);

            //username = user.getUsername();

            jwt = Jwts.builder()
                    .claim("userId", newUser.getId())
                    .claim("username", newUser.getUsername())
                    .signWith(key)
                    .compact();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        NewCookie cookie = new NewCookie("token", jwt);

        return Response.status(Response.Status.OK).entity(jwt).cookie(cookie).build();
    }
}
