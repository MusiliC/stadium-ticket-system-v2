package com.cee.tech.app.bean.sharedbean;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.database.MySqlDatabase;
import com.cee.tech.utils.HashText;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Remote
@Stateless
public class AuthBeanImpl implements Serializable, AuthBeanI {

    @EJB
    MySqlDatabase mySqlDatabase;

    @Inject
    private HashText hashText;
    User userDetails = null;
    public User authenticateUser(User loginUser) throws SQLException {

        try {
            loginUser.setPassword(hashText.hash(loginUser.getPassword()));
        } catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }


        String sqlQuery = "select id,username from users where username = ? and password = ? limit 1";


        PreparedStatement sqlStmt =mySqlDatabase.getConnection().prepareStatement(sqlQuery);

        sqlStmt.setString(1, loginUser.getUsername());
        sqlStmt.setString(2, loginUser.getPassword());

        User user = new User();

        ResultSet result = sqlStmt.executeQuery();

        while (result.next()){
            user.setId(result.getInt("id"));
            user.setUsername(result.getString("username"));
        }

        return user;
    }
}
