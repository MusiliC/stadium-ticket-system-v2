package com.cee.tech.app.action.adminactions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.view.html.HtmlAdminPages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminticketreport")
public class AdminTicketReportAction extends BaseActionClass {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        renderAdminPage(req, res, HtmlAdminPages.adminFixtureReport());
    }
}
