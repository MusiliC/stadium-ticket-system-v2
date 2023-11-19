package com.cee.tech.app.bean.sharedbean;

import com.cee.tech.app.model.entity.User;

public interface AuthBeanI {
    public User authenticateUser(User loginUser);
}
