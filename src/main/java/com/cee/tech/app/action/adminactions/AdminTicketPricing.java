package com.cee.tech.app.action.adminactions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.adminbean.TicketPricingBeanI;
import com.cee.tech.app.bean.adminbean.TicketPricingBean;
import com.cee.tech.app.model.entity.TicketPricing;
import com.cee.tech.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminticketpricing")
public class AdminTicketPricing extends BaseActionClass {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        Database database = Database.getDbInstance();

     database.getTicketPricing().add(new TicketPricing(req.getParameter("fixtureType"),Integer.parseInt( req.getParameter("vipTicketPrice")),Integer.parseInt( req.getParameter("normalTicketPrice"))));

     res.sendRedirect("./adminticketpricing");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        TicketPricingBeanI ticketPricingBean = new TicketPricingBean();

        renderAdminPage(req, res, "   <div class=\"TicketPricingContainer\">\n" +
                "      <div class=\"createFixtureContainer\">\n" +
                "        <p class=\"fixtureTitle\">Ticket Pricing</p>\n" +
                "\n" +
                "        <form action=\"./adminticketpricing\" method=\"post\">\n" +
                "          <div class=\"formTicketContainer\">\n" +
                "            <div class=\"formTicketInput\">\n" +
                "              <label for=\"fixtureType\">Fixture Type:</label>\n" +
                "              <select\n" +
                "                name=\"fixtureType\"\n" +
                "                id=\"fixtureType\"\n" +
                "                class=\"fixtureStyling\"\n" +
                "              >\n" +
                "                <option value=\"\" selected disabled hidden>\n" +
                "                  Choose fixture type\n" +
                "                </option>\n" +
                "                <option value=\"Kenya Premier League\">\n" +
                "                  Kenya Premier League\n" +
                "                </option>\n" +
                "                <option value=\"Mozzart Cup\">Mozzart Cup</option>\n" +
                "                <option value=\"CAF Champions League\">\n" +
                "                  CAF Champions League\n" +
                "                </option>\n" +
                "                <option value=\"CAF confederation\">CAF confederation</option>\n" +
                "              </select>\n" +
                "            </div>\n" +
                "            <div class=\"formTicketInput\">\n" +
                "              <label for=\"vipTicketPrice\">VIP Ticket Price:</label>\n" +
                "              <input type=\"number\" name=\"vipTicketPrice\" id=\"vipTicketPrice\" />\n" +
                "            </div>\n" +
                "            <div class=\"formTicketInput\">\n" +
                "              <label for=\"normalTicketPrice\">Normal Ticket Price:</label>\n" +
                "              <input type=\"number\" name=\"normalTicketPrice\" id=\"normalTicketPrice\" />\n" +
                "            </div>\n" +
                "          \n" +
                "          </div>\n" +
                "          <input class=\"normalFormButton\" type=\"submit\" value=\"Submit\" />\n" +
                "        </form>\n" +
                "\n" +
                "        <!-- Ticket table -->\n" +
                "       <div class=\"tablePricing\">\n" +
                "        <div class=\"ticketPriceTitle\">\n" +
                "          <p>Available Tickets</p>\n" +
                "        </div>\n" +
                ticketPricingBean.ticketPricesData()  +
                "      </div>\n" +
                "  \n" +
                "        </div>\n" +
                "      </div>\n" +
                "\n" +
                "      </div>\n" +
                "    </div>");

    }
}
