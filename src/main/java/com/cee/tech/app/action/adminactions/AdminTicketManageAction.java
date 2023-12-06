package com.cee.tech.app.action.adminactions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.adminbean.AdminTicketManagementI;
import com.cee.tech.app.bean.adminbean.AdminTicketManagementBeanImpl;
import com.cee.tech.app.model.entity.TicketManagement;
import com.cee.tech.database.Database;
import com.cee.tech.view.html.HtmlAdminPages;
import com.cee.tech.view.html.HtmlComponents;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminticketpricing")
public class AdminTicketManageAction extends BaseActionClass {

    @EJB
    AdminTicketManagementI adminTicketManagementBean;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        TicketManagement newTicket = new TicketManagement();

        serializeForm(newTicket, req.getParameterMap());

        adminTicketManagementBean.addOrUpdate(newTicket);

        res.sendRedirect("./adminticketpricing");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        renderAdminPage(req, res, HtmlAdminPages.adminTicketManageListPage(HtmlComponents.table(TicketManagement.class, adminTicketManagementBean.list(new TicketManagement())))
        );

    }
}
