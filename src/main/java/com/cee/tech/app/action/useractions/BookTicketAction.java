package com.cee.tech.app.action.useractions;


import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.userbean.BookTicketI;
import com.cee.tech.app.model.entity.BookTicket;
import com.cee.tech.view.html.HtmlComponents;
import com.cee.tech.view.html.HtmlUserPages;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book")
public class BookTicketAction extends BaseActionClass {

    @EJB
    BookTicketI bookTicketBean;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws  ServletException, IOException{
        BookTicket newBookTicket = new BookTicket();
        serializeForm(newBookTicket, req.getParameterMap());

        bookTicketBean.addOrUpdate(newBookTicket);

        res.sendRedirect("./tickets");

    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

        renderPage(req,res, HtmlUserPages.bookTicketPage(HtmlComponents.ticketForm(BookTicket.class) )
               );

    }
}
