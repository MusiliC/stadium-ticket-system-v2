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
                "        <form action=\"./adminticketpricing\" method=\"post\">\n" +
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
                "              <label for=\"totalTicketsAllocated\">Total Tickets Allocated:</label>\n" +
                "              <input type=\"number\" name=\"totalTicketsAllocated\" id=\"totalTicketsAllocated\" />\n" +
                "            </div>\n" +
                "            \n" +
                "            <div class=\"formInput\">\n" +
                "              <label for=\"totalVipTicketsLocated\">Total VIP tickets:</label>\n" +
                "              <input type=\"number\" name=\"totalVipTicketsLocated\" id=\"totalVipTicketsLocated\" />\n" +
                "            </div>\n" +
                "            <div class=\"formInput\">\n" +
                "              <label for=\"ticketAmountVIP\">VIP ticket amount:</label>\n" +
                "              <input type=\"number\" name=\"ticketAmountVIP\" id=\"ticketAmountVIP\" />\n" +
                "            </div>\n" +
                "            <div class=\"formInput\">\n" +
                "              <label for=\"totalNormalTicketsAllocated\">Total Normal tickets:</label>\n" +
                "              <input type=\"number\" name=\"totalNormalTicketsAllocated\" id=\"totalNormalTicketsAllocated\" />\n" +
                "            </div>\n" +
                "            <div class=\"formInput\">\n" +
                "              <label for=\"ticketAmountNormal\">Normal ticket amount:</label>\n" +
                "              <input type=\"number\" name=\"ticketAmountNormal\" id=\"ticketAmountNormal\" />\n" +
                "            </div>\n" +
                "          \n" +
                "          </div>\n" +
                "          <input class=\"normalFormButton\" type=\"submit\" value=\"Submit\" />\n" +
                "        </form>\n" +
                "      </div>\n" +
                "    </div>");

    }
}
