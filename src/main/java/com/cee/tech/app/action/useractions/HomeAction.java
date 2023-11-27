package com.cee.tech.app.action.useractions;

import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.utils.CookieUtils;
import com.cee.tech.view.html.HtmlUserPages;


@WebServlet("/home")
public class HomeAction extends BaseActionClass {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Cookie userCookie = CookieUtils.getCookieByName(req, "username");
        String accessCookie = null;

        if (userCookie != null) {
            accessCookie = userCookie.getValue();
        } else {
            System.out.println("Cookie not found");
        }

       renderPage(req,res, HtmlUserPages.homePage());


    }
}
