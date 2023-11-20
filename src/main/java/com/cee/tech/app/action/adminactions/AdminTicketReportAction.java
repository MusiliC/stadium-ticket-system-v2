package com.cee.tech.app.action.adminactions;

import com.cee.tech.app.action.BaseActionClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminticketreport")
public class AdminTicketReportAction extends BaseActionClass {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        renderAdminPage(req, res, "    <div class=\"adminTableContainer\">\n" +
                "      <p class=\"fixtureTitleTable\">Ticket Report</p>\n" +
                "      <table>\n" +
                "        <tr>\n" +
                "          <th>Field</th>\n" +
                "          <th>Data</th>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>Fixture</td>\n" +
                "          <td>Gor vs AFC - 11/11/2023</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>Fixture Type</td>\n" +
                "          <td>Kenya Premier League</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>Total Allocated Tickets</td>\n" +
                "          <td>1000</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>Total Sold</td>\n" +
                "          <td>500</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>Not Sold</td>\n" +
                "          <td>500</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>Normal Tickets sold</td>\n" +
                "          <td>100</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>Normal generated outcome</td>\n" +
                "          <td>10,000</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>VIP Tickets sold</td>\n" +
                "          <td>50</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>vip generated outcome</td>\n" +
                "          <td>7,000</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>Total generated outcome</td>\n" +
                "          <td>70,000</td>\n" +
                "        </tr>\n" +
                "      </table>\n" +
                "      <div class=\"ticketReportButton\">\n" +
                "        <a href=\"#\" class=\"ticketReportOneButton\">Download</a>\n" +
                "      </div>\n" +
                "    </div>");

    }
}
