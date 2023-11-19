package com.cee.tech.app.action.adminactions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.sharedbean.UserBean;
import com.cee.tech.app.bean.userbean.UserBeanI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/adminusers")
public class AdminUserReport extends BaseActionClass {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        UserBeanI userBean = new UserBean();

        renderAdminPage(req, res, "   <div class=\"adminTableContainer\">\n" +
                "      <p class=\"fixtureTitleTable\">Users Report</p>\n" +
                "\n" +
                userBean.list(UserBean.class) +
                "      <div class=\"ticketReportButton\">\n" +
                "        <a href=\"#\" class=\"ticketReportOneButton\">Download</a>\n" +
                "      </div>\n" +
                "    </div>");


    }
}
