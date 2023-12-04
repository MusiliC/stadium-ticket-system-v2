package com.cee.tech.app.action.useractions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.sharedbean.FixtureBeanI;
import com.cee.tech.app.bean.userbean.FixtureBeanImp;
import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.database.Database;
import com.cee.tech.view.html.HtmlUserPages;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/fixtures")
public class FixtureAction extends BaseActionClass {

    @EJB(beanName = "userFixtureBean")
    FixtureBeanI fixtureBean;

    @Inject
    private List<String> developers;




    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        System.out.println("Developers are:");
        for (String developer: developers)
            System.out.println(developer);

       // Fixture fixture = new Fixture();

        renderPage(req, res, HtmlUserPages.titleHeader("Upcoming Fixtures") +
                fixtureBean.upcomingFixtures() +
                HtmlUserPages.titleClosingTags() + fixtureBean.upcomingFixtures()
        );

    }


}