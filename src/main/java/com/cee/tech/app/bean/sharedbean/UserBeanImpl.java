package com.cee.tech.app.bean.sharedbean;

import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.bean.userbean.UserBeanI;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.database.Database;
import com.cee.tech.database.MySqlDatabase;
import com.cee.tech.view.html.HtmlComponents;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Remote
@Stateless
public class UserBeanImpl extends GenericBeanImpl<User> implements UserBeanI {

    @Override
    public boolean registerUser(User user) throws SQLException {

        if (!user.getPassword().equals(user.getConfirmPassword()))
            throw new RuntimeException("Password & confirm password do not match");

        //1. check if username already exist
        //2. hash password
        //3. initiate event to send email ...Observer design pattern

        getDao().addOrUpdate(user);

        return false;

    };

    @Override
    public boolean unregisterUser(User user) {
    return false;
    }

    @Override
    public String allRegisteredUsers() {
        List<User> users = Database.getDbInstance().getUsers();

        return HtmlComponents.table(User.class,users);
    }



}
