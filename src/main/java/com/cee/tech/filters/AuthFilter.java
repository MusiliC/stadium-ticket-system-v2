package com.cee.tech.filters;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession httpSession = httpRequest.getSession();

        String servletPath = httpRequest.getServletPath();
        System.out.println("Servlet path: " + servletPath);
        System.out.println("Context path: " + httpRequest.getContextPath());
        System.out.println("Context URI: " + httpRequest.getRequestURI());

        if (httpSession.isNew() || StringUtils.isBlank((String) httpSession.getAttribute("LoginId"))) {
            httpSession.invalidate();

            if (servletPath.equals("/login") || servletPath.endsWith(".jsp") || servletPath.equals("/register")
                    || servletPath.equals("/user"))
                chain.doFilter(request, response);
            else {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
                response.getWriter().flush();
            }
        } else {
            if (StringUtils.isNotBlank((String) httpSession.getAttribute("LoginId"))) {
                httpResponse.addHeader("AuthTime", DateFormat.getDateTimeInstance().format(new Date()));

                // Check if the user is an admin
                String username = (String) httpSession.getAttribute("username");
                if ("Admin".equals(username)) {
                    // User is an admin, allow access to /admin pages
                    if (servletPath.startsWith("/admin") || servletPath.startsWith("/")) {
                        chain.doFilter(request, response);
                    } else {
                        httpResponse.sendRedirect(httpRequest.getContextPath() + "/admin");
                    }
                } else {
                    if (servletPath.startsWith("/admin")) {
                        httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
                        response.getWriter().flush();
                    } else {
                        chain.doFilter(request, response);
                    }
                }
            } else {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
                response.getWriter().flush();
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}