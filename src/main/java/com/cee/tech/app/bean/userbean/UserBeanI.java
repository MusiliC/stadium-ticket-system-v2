package com.cee.tech.app.bean.userbean;

import com.cee.tech.app.bean.GenericBeanI;
import com.cee.tech.app.model.entity.User;

import java.sql.SQLException;

public interface UserBeanI extends GenericBeanI<User> {
    boolean registerUser(User user) throws SQLException;

    boolean unregisterUser(User user);

    public String allRegisteredUsers();
}
