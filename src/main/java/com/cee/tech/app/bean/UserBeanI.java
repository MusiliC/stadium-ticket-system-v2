package com.cee.tech.app.bean;

import com.cee.tech.app.model.entity.User;

public interface UserBeanI {
    boolean registerUser(User user);

    boolean unregisterUser(User user);

    public String allRegisteredUsers();
}
