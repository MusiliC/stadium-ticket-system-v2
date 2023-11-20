package com.cee.tech.app.bean.sharedbean;

import com.cee.tech.app.model.entity.User;

import java.sql.SQLException;

public interface AuthBeanI {
    public User authenticateUser(User loginUser) throws SQLException;
}
