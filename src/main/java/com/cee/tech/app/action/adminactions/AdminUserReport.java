package com.cee.tech.app.action.adminactions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.adminbean.UserBean;
import com.cee.tech.app.bean.UserBeanI;

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
                userBean.allRegisteredUsers() +
                "      <div class=\"ticketReportButton\">\n" +
                "        <a href=\"#\" class=\"ticketReportOneButton\">Download</a>\n" +
                "      </div>\n" +
                "    </div>");
    }
}
