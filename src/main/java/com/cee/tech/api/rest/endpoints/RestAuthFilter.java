//package com.cee.tech.api.rest.endpoints;
//
//import com.cee.tech.app.bean.sharedbean.AuthBeanI;
//import com.cee.tech.app.model.entity.User;
//
//import javax.annotation.Priority;
//import javax.annotation.security.DenyAll;
//import javax.annotation.security.RolesAllowed;
//import javax.ejb.EJB;
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//import javax.ws.rs.container.ResourceInfo;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.MultivaluedMap;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.ext.Provider;
//import java.io.IOException;
//import java.lang.reflect.Method;
//import java.nio.charset.StandardCharsets;
//import java.sql.SQLException;
//import java.util.Base64;
//import java.util.List;
//
//@Provider
//@Priority(2)
//public class RestAuthFilter implements ContainerRequestFilter {
//
//    @Context
//    ResourceInfo resourceInfo;
//
//    @EJB
//    AuthBeanI authBean;
//
//    @Override
//    public void filter(ContainerRequestContext requestContext) throws IOException {
//        Method method = resourceInfo.getResourceMethod();
//        if (method.isAnnotationPresent(DenyAll.class) || !method.isAnnotationPresent(RolesAllowed.class)) {
//            abort(requestContext, "Not allowed");
//            return;
//        }
//
//        //GET HEADERS
//        final MultivaluedMap<String, String> headers = requestContext.getHeaders();
//
//        //GET AUTHORIZATION HEADER
//        List<String> authorization = headers.get("Authorization");
//
//        //If no authorization header abort
//        if (authorization == null || authorization.isEmpty() || authorization.get(0) == null) {
//            abort(requestContext, "Authorization not provided");
//            return;
//        }
//
//        String basicAuth = authorization.get(0);
//
//        //if auth header value does not contain basic
//        if (!basicAuth.contains("Basic")) {
//            abort(requestContext, "Basic authentication required");
//            return;
//        }
//
//        //remove basic
//        String base64Auth = basicAuth.replace("Basic", "").trim();
//
//        System.out.println("Embedded username and password " + base64Auth);
//
//        byte[] decodeUserPwd = Base64.getDecoder().decode(base64Auth);
//
//        System.out.println(new String(decodeUserPwd, StandardCharsets.UTF_8));
//
//        String[] usernameAndPwd = new String(decodeUserPwd, StandardCharsets.UTF_8).split(":");
//
//        //user and password authentication
//
//        User user = new User();
//
//        user.setUsername(usernameAndPwd[0]);
//        user.setPassword(usernameAndPwd[1]);
//
//        try {
//            authBean.authenticateUser(user);
//        } catch (SQLException e) {
//            abort(requestContext, "Internal server error");
//
//        }
//
//
//    }
//
//    private void abort(ContainerRequestContext requestContext, String message) {
//        requestContext.abortWith(Response.status(Response.Status.FORBIDDEN)
//                .entity(new RestResponseWrapper(false, message))
//                .type(MediaType.APPLICATION_JSON).build());
//    }
//}
