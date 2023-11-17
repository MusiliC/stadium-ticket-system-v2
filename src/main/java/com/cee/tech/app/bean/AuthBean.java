package com.cee.tech.app.bean;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.database.Database;

import java.io.Serializable;

public class AuthBean implements Serializable,AuthBeanI {
    Database database = Database.getDbInstance();
    User userDetails = null;
    public User authenticateUser(User loginUser){
        for (User user : database.getUsers()) {
            if (loginUser.getUsername().equals(user.getUsername()) && loginUser.getPassword().equals(user.getPassword())) {
             userDetails = user;
             break;
            }
        }
        return userDetails;
    }
}
