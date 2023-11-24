package com.cee.tech.app.action.useractions;


import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.model.entity.Ticket;
import com.cee.tech.view.html.HtmlComponents;
import com.cee.tech.view.html.HtmlUserPages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book")
public class BookTicketAction extends BaseActionClass {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

        renderPage(req,res, HtmlUserPages.bookTicketPage(HtmlComponents.ticketForm(Ticket.class) )
               );

    }
}
