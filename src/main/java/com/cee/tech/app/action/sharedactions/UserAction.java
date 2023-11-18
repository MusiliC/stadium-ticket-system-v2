package com.cee.tech.app.action.sharedactions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.adminbean.UserBean;
import com.cee.tech.app.bean.UserBeanI;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.database.Database;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user")
public class UserAction extends BaseActionClass {

    UserBeanI userBean = new UserBean();

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Database database = Database.getDbInstance();

        User registerUser = new User();
        serializeForm(registerUser, req.getParameterMap());

        userBean.registerUser(registerUser);
        res.sendRedirect("./");

    }
}
