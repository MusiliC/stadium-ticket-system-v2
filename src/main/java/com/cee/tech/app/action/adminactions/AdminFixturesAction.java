package com.cee.tech.app.action.adminactions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.sharedbean.FixtureBeanI;
import com.cee.tech.app.bean.adminbean.FixtureAdminBean;
import com.cee.tech.app.model.entity.Fixture;

import com.cee.tech.database.Database;
import com.cee.tech.view.html.HtmlComponents;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminfixtures")
public class AdminFixturesAction extends BaseActionClass {
    FixtureBeanI adminFixtureBean = new FixtureAdminBean();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        Database database = Database.getDbInstance();

        Fixture getAdminFixture = new Fixture();

        database.getFixtures().add(new Fixture(req.getParameter("fixtureType"),req.getParameter("fixtureTime"),req.getParameter("fixtureLocation"),req.getParameter("homeTeam"),req.getParameter("awayTeam"),req.getParameter("fixtureDate")));

        res.sendRedirect("./adminfixtures");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        renderAdminPage(req, res, "    <div class=\"mainFixtureContainer\">\n" +
                "      <!-- top part -->\n" +
                "      <!-- bottom part  -->\n" +
                "      <div class=\"fixtureAdminContainer\">\n" +
                "        <!-- each fixture div -->\n" +
                HtmlComponents.table(Fixture.class,adminFixtureBean.list(Fixture.class) ) +
                "      </div>\n" +
                "    </div>");

    }
}

