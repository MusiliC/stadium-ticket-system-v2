package com.cee.tech.app.bean.sharedbean;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.database.MySqlDatabase;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthBeanImpl implements Serializable, AuthBeanI {

    User userDetails = null;
    public User authenticateUser(User loginUser) throws SQLException {


        String sqlQuery = "select id,username from users where username = ? and password = ? limit 1";
        PreparedStatement sqlStmt =MySqlDatabase.getInstance().getConnection().prepareStatement(sqlQuery);

        sqlStmt.setString(1, loginUser.getUsername());
        sqlStmt.setString(2, loginUser.getPassword());

        User user = new User();

        ResultSet result = sqlStmt.executeQuery();

        while (result.next()){
            user.setId(result.getInt("id"));
            user.setUsername(result.getString("username"));
        }

        return  user;
    }
}
