package com.cee.tech.app.action.useractions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.userbean.BookTicketI;
import com.cee.tech.app.model.entity.BookTicket;
import com.cee.tech.utils.CookieUtils;
import com.cee.tech.view.html.HtmlComponents;
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
        Cookie userCookie = CookieUtils.getCookieByName(req, "username");
        assert userCookie != null;
        System.out.println(userCookie.getValue());
        try {
            try {
                renderPage(req, res , HtmlComponents.bookTicketCard(BookTicket.class, bookTicketBean.list(BookTicket.class)));
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

