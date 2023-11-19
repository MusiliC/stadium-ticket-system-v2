package com.cee.tech.app.action.useractions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.userbean.FixtureBean;
import com.cee.tech.app.bean.sharedbean.FixtureBeanI;
import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/fixtures")
public class FixtureAction extends BaseActionClass {

    private Fixture fixture = new Fixture();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Database database = Database.getDbInstance();
        FixtureBeanI fixtureBean = new FixtureBean();


        renderPage(req, res, "    <div class=\"mainFixtureContainer\">\n" +
                "      <!-- top part -->\n" +
                "      <div class=\"topPart\">\n" +
                "        <div class=\"topPartTitle\">\n" +
                "          <p>Upcoming Fixtures</p>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "      <!-- bottom part  -->\n" +
                "      <div class=\"fixtureContainer\">\n" +
                "        <!-- each fixture div -->\n" +
                fixtureBean.upcomingFixtures() +

                "      </div>\n" +
                "    </div>");



    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Database database = Database.getDbInstance();


        serializeForm(fixture, req.getParameterMap());
        database.getFixtures().add(fixture);

        res.sendRedirect("./fixtures");


    }
}