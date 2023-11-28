package com.cee.tech.app.action.useractions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.userbean.BookTicketI;
import com.cee.tech.app.model.entity.BookTicket;
import com.cee.tech.view.html.HtmlUserPages;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/tickets")
public class TicketAction extends BaseActionClass {

    @EJB
    BookTicketI bookTicketBean;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        BookTicket newTicket = new BookTicket();

        bookTicketBean.addOrUpdate(newTicket);

        res.sendRedirect("./tickets");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        renderPage(req, res , HtmlUserPages.myTicketsPage());
    }
}