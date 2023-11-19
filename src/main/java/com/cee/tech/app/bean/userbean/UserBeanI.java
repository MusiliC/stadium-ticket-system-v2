package com.cee.tech.app.bean.userbean;

import com.cee.tech.app.bean.GenericBeanI;
import com.cee.tech.app.model.entity.User;

public interface UserBeanI extends GenericBeanI<User> {
    boolean registerUser(User user);

    boolean unregisterUser(User user);

    public String allRegisteredUsers();
}
