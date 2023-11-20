package com.cee.tech.app.action.sharedactions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.sharedbean.AuthBean;
import com.cee.tech.app.bean.sharedbean.AuthBeanI;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.utils.CustomLogger;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = "/login", initParams = {
        @WebInitParam(name = "username", value = "Musili"),
        @WebInitParam(name = "password", value = "Admin123")
})
public class LoginAction extends BaseActionClass {

    AuthBeanI authBean = new AuthBean();
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        if (StringUtils.isNotBlank((String) httpSession.getAttribute("LoginId")))
            res.sendRedirect("/home");
        else
            res.sendRedirect("./");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        CustomLogger logger = CustomLogger.getLoggerInstance();

        User loginUser = new User();
        serializeForm(loginUser, req.getParameterMap());

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {

            User userDetails = authBean.authenticateUser(loginUser);


            if (userDetails != null) {
                HttpSession httpSession = req.getSession(true);
                httpSession.setAttribute("LoginId", new Date().getTime() + "");
                // implementing cookies
                Cookie newCookie = new Cookie("username", username);
                res.addCookie(newCookie);
                // sending data -> another servlet
                httpSession.setAttribute("username", username);
                if ("Admin".equals(username)) {
                    res.sendRedirect("./admin");
                } else {
                    res.sendRedirect("./home");
                }

            }

            PrintWriter print = res.getWriter();

            print.write("<html><body>Invalid credentials! <a href=\".\"> Login again </a></body></html>");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
