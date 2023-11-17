package com.cee.tech.app.action.userActions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.utils.CookieUtils;
import com.cee.tech.utils.CustomLogger;



@WebServlet("/home")
public class HomeAction extends BaseActionClass {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


        CustomLogger logger = CustomLogger.getLoggerInstance();

        Cookie userCookie = CookieUtils.getCookieByName(req, "username");
        String accessCookie = null;

        if (userCookie != null) {
            accessCookie = userCookie.getValue();
        } else {
            System.out.println("Cookie not found");
        }

        logger.log(Level.INFO, "********** " + accessCookie + "***************");

        renderPage(req,res," <div class=\"mainContainer\">\n" +
                "      <div class=\"heroSection\">\n" +
                "        <div class=\"sectionTitle\">\n" +
                "          <p>\n" +
                "            Experience The <br />\n" +
                "            <span class=\"blueText\">Thrill of Live Sports </span> <br />\n" +
                "            Like Never Before\n" +
                "          </p>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "          <p class=\"summary\">\n" +
                "            Experience the ultimate in live entertainment with our seamless\n" +
                "            ticketing system. Get ready to secure your spot at the heart of the\n" +
                "            action\n" +
                "          </p>\n" +
                "        </div>\n" +
                "        <div class=\"homeButtons\">\n" +
                "            <a href=\"./tickets\" class=\"homeOutlineButton\" >  My Tickets</a>\n" +
                "            <a href=\"./fixtures\" class=\"homeNormalButton\">Upcoming Fixtures</a>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "      <div class=\"heroImage\">\n" +
                "        <div class=\"imageContainer\">\n" +
                "          <img class=\"bgImage\" src=\"https://images.unsplash.com/photo-1522778526097-ce0a22ceb253?auto=format&fit=crop&q=80&w=1470&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D\" alt=\"stadium\">\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>");


    }
}
