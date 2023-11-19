package com.cee.tech.app.bean;

import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.database.Database;
import com.cee.tech.view.html.HtmlComponents;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericBeanImpl<T> implements  GenericBeanI<T>{
    Database database = Database.getDbInstance();

    @Override
    public String list(Class<?> entity) {

        List<User> users = Database.getDbInstance().getUsers();
        return HtmlComponents.table(users);
        //return (List<T>) users;
    }

    @Override
    public T addOrUpdate(T entity) {
        return null;
    }

    @Override
    public void delete(T entity) {

    }
}
