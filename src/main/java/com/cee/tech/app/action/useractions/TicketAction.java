package com.cee.tech.app.action.useractions;

import com.cee.tech.app.action.BaseActionClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/tickets")
public class TicketAction extends BaseActionClass {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        renderPage(req, res , "<div class=\"topTicketPart\">\n" +
                "        <div class=\"topTicketPartTitle\">\n" +
                "          <p>My Tickets</p>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    <div class=\"mainTicketContainer\">\n" +
                "      \n" +
                "        <div class=\"fixtureCard\">\n" +
                "            <div>\n" +
                "                <img width=\"50\" height=\"50\" src=\"https://img.icons8.com/ios-filled/50/football2--v1.png\" alt=\"football2--v1\"/>\n" +
                "            </div>\n" +
                "            <div class=\"ticketInfoDetails\">\n" +
                "                <p class=\"kpl\">Kenya Premier League</p>      \n" +
                "                <p class=\"game\">Gor Mahia vs Afc Leopards</p>\n" +
                "                <p>MISC Kasarani</p>\n" +
                "              </div>  \n" +
                "           <div>\n" +
                "            <p>Ticket Number: 1001</p>\n" +
                "           </div>  \n" +
                "           <div>\n" +
                "            <div class=\"myTicketNormalButton\">\n" +
                "                <a href=\"./ticketdetails\">Ticket Details</a> \n" +
                "            </div>\n" +
                "           </div>          \n" +
                "        </div>\n" +
                "        <div class=\"fixtureCard\">\n" +
                "            <div>\n" +
                "                <img width=\"50\" height=\"50\" src=\"https://img.icons8.com/ios-filled/50/football2--v1.png\" alt=\"football2--v1\"/>\n" +
                "            </div>\n" +
                "            <div class=\"ticketInfoDetails\">\n" +
                "                <p class=\"kpl\">CAF Champions League</p>      \n" +
                "                <p class=\"game\">Gor Mahia vs Afc Leopards</p>\n" +
                "                <p>MISC Kasarani</p>\n" +
                "              </div>  \n" +
                "           <div>\n" +
                "            <p>Ticket Number: 1001</p>\n" +
                "           </div>  \n" +
                "           <div>\n" +
                "            <div class=\"myTicketNormalButton\">\n" +
                "               <a href=\"./ticketdetails\">Ticket Details</a> \n" +
                "            </div>\n" +
                "           </div>          \n" +
                "        </div>\n" +
                "        <div class=\"fixtureCard\">\n" +
                "            <div>\n" +
                "                <img width=\"50\" height=\"50\" src=\"https://img.icons8.com/ios-filled/50/football2--v1.png\" alt=\"football2--v1\"/>\n" +
                "            </div>\n" +
                "            <div class=\"ticketInfoDetails\">\n" +
                "                <p class=\"kpl\">Mozzart Cup</p>      \n" +
                "                <p class=\"game\">Gor Mahia vs Afc Leopards</p>\n" +
                "                <p>Nyayo stadium</p>\n" +
                "              </div>  \n" +
                "           <div>\n" +
                "            <p>Ticket Number: 1001</p>\n" +
                "           </div>  \n" +
                "           <div>\n" +
                "            <div class=\"myTicketNormalButton\">\n" +
                "                <a href=\"./ticketdetails\">Ticket Details</a> \n" +
                "            </div>\n" +
                "           </div>          \n" +
                "        </div>\n" +
                "    </div>");


    }
}