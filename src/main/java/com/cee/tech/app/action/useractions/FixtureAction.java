package com.cee.tech.app.action.useractions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.sharedbean.FixtureBeanI;
import com.cee.tech.app.bean.userbean.FixtureBeanImp;
import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.database.Database;
import com.cee.tech.view.html.HtmlUserPages;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/fixtures")
public class FixtureAction extends BaseActionClass {

    @EJB
    FixtureBeanI fixtureBean;

    private Fixture fixture = new Fixture();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Database database = Database.getDbInstance();


        renderPage(req, res, HtmlUserPages.titleHeader("Upcoming Fixtures") +
                fixtureBean.upcomingFixtures() +
                HtmlUserPages.titleClosingTags()
        );

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Database database = Database.getDbInstance();


        serializeForm(fixture, req.getParameterMap());
        database.getFixtures().add(fixture);

        res.sendRedirect("./fixtures");


    }
}