package com.cee.tech.app.action.adminactions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.adminbean.AdminTicketManagementI;
import com.cee.tech.app.bean.adminbean.AdminTicketManagementImpl;
import com.cee.tech.app.bean.adminbean.AdminTicketManagementBean;
import com.cee.tech.app.model.entity.TicketManagement;
import com.cee.tech.database.Database;
import com.cee.tech.view.html.HtmlComponents;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminticketpricing")
public class AdminTicketManageAction extends BaseActionClass {

    AdminTicketManagementI adminTicketManagement = new AdminTicketManagementBean();
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        Database database = Database.getDbInstance();

     //database.getTicketPricing().add(new TicketManagement(req.getParameter("fixtureType"),Integer.parseInt( req.getParameter("vipTicketPrice")),Integer.parseInt( req.getParameter("normalTicketPrice"))));

     res.sendRedirect("./adminticketpricing");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {



        renderAdminPage(req, res, "   <div class=\"TicketPricingContainer\">\n" +
                "      <div class=\"createFixtureContainer\">\n" +
                "        <p class=\"fixtureTitle\">Ticket Management List</p>\n" +
                "\n" +
                "        <!-- Ticket table -->\n" +
                "       <div class=\"tablePricing\">\n" +
                        HtmlComponents.table(TicketManagement.class,adminTicketManagement.list(TicketManagement.class) ) +
                "      </div>\n" +
                "  \n" +
                "        </div>\n" +
                "      </div>\n" +
                "\n" +
                "      </div>\n" +
                "    </div>");

    }
}
