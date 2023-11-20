package com.cee.tech.app.action.adminactions;

import com.cee.tech.app.action.BaseActionClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminticket")
public class AdminCreateTicketAction extends BaseActionClass {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        renderAdminPage(req, res, "    <div class=\"formMainContainer\">\n" +
                "      <div class=\"createFixtureContainer\">\n" +
                "        <p class=\"fixtureTitle\">Manage ticket for upcoming fixture</p>\n" +
                "\n" +
                "        <form action=\"./fixtures\" method=\"post\">\n" +
                "          <div class=\"formContainer\">\n" +
                "            <div class=\"formInput\">\n" +
                "                <label for=\"fixtureType\">Fixture Type:</label>\n" +
                "                <select name=\"fixtureType\" id=\"fixtureType\" class=\"fixtureStyling\">\n" +
                "                  <option value=\"\" selected disabled hidden>Choose fixture type</option>\n" +
                "                  <option value=\"Kenya Premier League\">Kenya Premier League</option>\n" +
                "                  <option value=\"Mozzart Cup\">Mozzart Cup</option>\n" +
                "                  <option value=\"CAF Champions League\">CAF Champions League</option>\n" +
                "                  <option value=\"CAF confederation\">CAF confederation</option>\n" +
                "                </select>\n" +
                "              </div>\n" +
                "            <div class=\"formInput\">\n" +
                "              <label for=\"totalTickets\">Total Tickets Allocated:</label>\n" +
                "              <input type=\"number\" name=\"totalTickets\" id=\"totalTickets\" />\n" +
                "            </div>\n" +
                "            \n" +
                "            <div class=\"formInput\">\n" +
                "              <label for=\"vipTickets\">Total VIP tickets:</label>\n" +
                "              <input type=\"number\" name=\"vipTickets\" id=\"vipTickets\" />\n" +
                "            </div>\n" +
                "            <div class=\"formInput\">\n" +
                "              <label for=\"vipAmount\">VIP ticket amount:</label>\n" +
                "              <input type=\"number\" name=\"vipAmount\" id=\"vipAmount\" />\n" +
                "            </div>\n" +
                "            <div class=\"formInput\">\n" +
                "              <label for=\"normalTickets\">Total Normal tickets:</label>\n" +
                "              <input type=\"number\" name=\"normalTickets\" id=\"normalTickets\" />\n" +
                "            </div>\n" +
                "            <div class=\"formInput\">\n" +
                "              <label for=\"normalAmount\">Normal ticket amount:</label>\n" +
                "              <input type=\"number\" name=\"normalAmount\" id=\"normalAmount\" />\n" +
                "            </div>\n" +
                "          \n" +
                "          </div>\n" +
                "          <input class=\"normalFormButton\" type=\"submit\" value=\"Submit\" />\n" +
                "        </form>\n" +
                "      </div>\n" +
                "    </div>");

    }
}
