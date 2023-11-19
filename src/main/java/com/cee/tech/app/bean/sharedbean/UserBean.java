package com.cee.tech.app.bean.sharedbean;

import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.bean.userbean.UserBeanI;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.database.Database;
import com.cee.tech.view.html.HtmlComponents;

import java.util.List;

public class UserBean extends GenericBeanImpl<User> implements UserBeanI {
    Database database = Database.getDbInstance();
    @Override
    public boolean registerUser(User user) {
        if (user.getPassword().equals(user.getConfirmPassword()))
            database.getUsers().add(new User("100", user.getUsername(),user.getPassword()));
        return true;
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