package com.cee.tech.app.action.adminactions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.sharedbean.UserBeanImpl;
import com.cee.tech.app.bean.userbean.UserBeanI;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.view.html.HtmlAdminPages;
import com.cee.tech.view.html.HtmlComponents;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/adminusers")
public class AdminUserReportAction extends BaseActionClass {
    @EJB
    UserBeanI userBean;
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        renderAdminPage(req, res, HtmlAdminPages.adminUserReport(HtmlComponents.table(User.class,userBean.list(User.class) ))
             );

        //testing for single item
//        StringBuilder test = new StringBuilder();
//
//        renderAdminPage(req, res,test.append("one data - for static id 1 - ").append ( userBean.selectSingle(User.class,1)
//        ).toString());

    }
}
