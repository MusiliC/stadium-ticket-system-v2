package com.cee.tech.app.action.adminactions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.sharedbean.UserBeanImpl;
import com.cee.tech.app.bean.userbean.UserBeanI;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.view.html.HtmlComponents;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/adminusers")
public class AdminUserReportAction extends BaseActionClass {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        UserBeanI userBean = new UserBeanImpl();

        renderAdminPage(req, res, "   <div class=\"adminTableContainer\">\n" +
                "      <p class=\"fixtureTitleTable\">Users Report</p>\n" +
                "\n" +
                HtmlComponents.table(userBean.list(User.class) ) +
                "      <div class=\"ticketReportButton\">\n" +
                "        <a href=\"#\" class=\"ticketReportOneButton\">Download</a>\n" +
                "      </div>\n" +
                "    </div>");


    }
}
