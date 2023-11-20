package com.cee.tech.app.bean.sharedbean;

import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.bean.userbean.UserBeanI;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.database.Database;
import com.cee.tech.database.MySqlDatabase;
import com.cee.tech.view.html.HtmlComponents;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserBean extends GenericBeanImpl<User> implements UserBeanI {

    @Override
    public boolean registerUser(User user) throws SQLException {



        if (user.getPassword().equals(user.getConfirmPassword())) {

            MySqlDatabase database = MySqlDatabase.getInstance();
            Connection conn = database.getConnection();

            String sqlQuery = "insert into user (username, password, normalTickets,vipTickets )values(?,?,?,?);";
            PreparedStatement sqlStmt = conn.prepareStatement(sqlQuery);

            sqlStmt.setString(1,user.getUsername());
            sqlStmt.setString(2,user.getPassword());
            sqlStmt.setInt(3,user.getNormalTickets());
            sqlStmt.setInt(4,user.getVipTickets());

            sqlStmt.executeUpdate();

            return true;
        }
        return false;
    };

    @Override
    public boolean unregisterUser(User user) {
    return false;
    }

    @Override
    public String allRegisteredUsers() {
        List<User> users = Database.getDbInstance().getUsers();

        return HtmlComponents.table(users);
    }


}
