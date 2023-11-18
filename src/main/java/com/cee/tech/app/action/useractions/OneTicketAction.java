package com.cee.tech.app.action.useractions;


import com.cee.tech.app.action.BaseActionClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ticketdetails")
public class OneTicketAction extends BaseActionClass {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

     renderPage(req, res, " <div class=\"ticketBodyContainer\">\n" +
             "      <div class=\"ticketDetailsTitle\">\n" +
             "        <p>Ticket Details</p>\n" +
             "      </div>\n" +
             "      <div class=\"mainOneTicketContainer\">\n" +
             "        <div class=\"oneTicketTop\">\n" +
             "          <div class=\"topOneTicketPart\">\n" +
             "            <div class=\"imagePart\">\n" +
             "              <img\n" +
             "                src=\"https://footballkenya.org/wp-content/uploads/2019/09/FKF-Website-Header-Logo-300x120.png\"\n" +
             "                alt=\"Logo\"\n" +
             "              />\n" +
             "            </div>\n" +
             "          </div>\n" +
             "          <div class=\"bottomTicketPart\">\n" +
             "            <div class=\"gameStyling\">\n" +
             "              <div class=\"fixtureType\">\n" +
             "                <p class=\"kpl\">Kenya Premier League</p>\n" +
             "                <p class=\"game\">Gor Mahia vs Afc Leopards</p>\n" +
             "                <p class=\"date\">3/11/2023</p>\n" +
             "              </div>\n" +
             "            </div>\n" +
             "            <div class=\"fineTicketDetails\">\n" +
             "              <div class=\"leftPart\">\n" +
             "                <div class=\"ticketType\">\n" +
             "                  <p>Type: VIP</p>\n" +
             "                </div>\n" +
             "\n" +
             "                <div class=\"amount\">\n" +
             "                  <p>Amount: 500</p>\n" +
             "                </div>\n" +
             "              </div>\n" +
             "              <div class=\"rightPart\">\n" +
             "                <div class=\"ticketNumber\">\n" +
             "                  <p>Ticket Number: 1001</p>\n" +
             "                </div>\n" +
             "                <div class=\"kickOff\">\n" +
             "                  <p>Kick Off: 1300 hrs</p>\n" +
             "                </div>\n" +
             "                <div class=\"location\">\n" +
             "                  <p>Location: Kasarani</p>\n" +
             "                </div>\n" +
             "              </div>\n" +
             "            </div>\n" +
             "          </div>\n" +
             "        </div>\n" +
             "      </div>\n" +
             "      <div class=\"ticketButtons\">\n" +
             "        <a href=\"./tickets\" class=\"ticketNormalButton\">Back</a>\n" +
             "        <a href=\"#\" class=\"ticketOutlineButton\">Download</a>\n" +
             "      </div>\n" +
             "    </div>");

    }
}