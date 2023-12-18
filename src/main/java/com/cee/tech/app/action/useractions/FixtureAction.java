package com.cee.tech.app.action.useractions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.sharedbean.FixtureBeanI;
import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.view.html.HtmlComponents;
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
        for (String developer : developers)
            System.out.println(developer);
        try {
            renderPage(req, res, HtmlUserPages.titleHeader("Upcoming Fixtures") +
                    HtmlComponents.fixtureCard(Fixture.class, fixtureBean.list(new Fixture())) +
                    HtmlUserPages.titleClosingTags()
            );
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }


}