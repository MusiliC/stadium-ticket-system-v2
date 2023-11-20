package com.cee.tech.app.action.sharedactions;

import com.cee.tech.app.action.BaseActionClass;
import com.cee.tech.app.bean.sharedbean.UserBeanImpl;
import com.cee.tech.app.bean.userbean.UserBeanI;
import com.cee.tech.app.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user")
public class UserAction extends BaseActionClass {

    UserBeanI userBean = new UserBeanImpl();

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


            User registerUser = new User();
            serializeForm(registerUser, req.getParameterMap());
            try {
                userBean.registerUser(registerUser);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }



        res.sendRedirect("./");

    }
}
