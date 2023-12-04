package com.cee.tech.app.action.adminactions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.adminbean.AdminTicketManagementI;
import com.cee.tech.app.bean.adminbean.FixtureAdminBeanImpl;
import com.cee.tech.app.bean.sharedbean.FixtureBeanI;
import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.app.model.entity.TicketManagement;
import com.cee.tech.view.html.HtmlAdminPages;
import com.cee.tech.view.html.HtmlComponents;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminticket")
public class AdminCreateTicketAction extends BaseActionClass {



    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        renderAdminPage(req, res, HtmlAdminPages.adminCreateTicketManagement( HtmlComponents.form(TicketManagement.class))
        );

    }

}
