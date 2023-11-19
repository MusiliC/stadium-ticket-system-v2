package com.cee.tech.app.bean;

import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.database.Database;
import com.cee.tech.view.html.HtmlComponents;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class GenericBeanImpl<T> implements  GenericBeanI<T>{
    Database database = Database.getDbInstance();

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<T> list(Class<?> entity) {

        if (entity.equals(User.class))
            return (List<T>) database.getUsers();

        if (entity.equals(Fixture.class))
            return (List<T>) database.getFixtures();


        return new ArrayList<>();
    }

//    @Override
//    public List<T> list(Class<?> entity) {
//
//        List<User> users = Database.getDbInstance().getUsers();
//        //return HtmlComponents.table(users);
//        return (List<T>) users;
//    }

//    @SuppressWarnings({"unchecked","rawtypes"})
//    @Override
//    public List<T> list(Class<?> entity) {
//        return (List<T>) Database.getDbInstance().getData(entity);
//
//    }

    @Override
    public T addOrUpdate(T entity) {
        return null;
    }

    @Override
    public void delete(T entity) {

    }
}
