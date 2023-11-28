package com.cee.tech.app.action.adminactions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.adminbean.FixtureAdminBeanImpl;
import com.cee.tech.app.bean.sharedbean.FixtureBeanI;
import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.view.html.HtmlAdminPages;
import com.cee.tech.view.html.HtmlComponents;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class AdminHomeAction extends BaseActionClass {

    @EJB(beanName = "adminFixtureBean")
    FixtureBeanI adminFixtureBean;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

        Fixture newAdminFixture = new Fixture();
        serializeForm(newAdminFixture, req.getParameterMap());


        adminFixtureBean.addOrUpdate(newAdminFixture);
        res.sendRedirect("./adminfixtures");
    }


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        renderAdminPage(req, res, HtmlAdminPages.adminHomePage(HtmlComponents.form(Fixture.class) )
               );
    }

}
