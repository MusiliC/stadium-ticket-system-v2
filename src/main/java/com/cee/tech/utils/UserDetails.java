package com.cee.tech.utils;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

@Named("UserDetails")
public class UserDetails {

    @Inject
    @Context
    private HttpServletRequest request;

    public String getUsernameFromCookie(String cookieName) {
        Cookie userCookie = CookieUtils.getCookieByName(request, cookieName);
        if (userCookie != null) {
            return userCookie.getValue();
        }
        return null;
    }
}
