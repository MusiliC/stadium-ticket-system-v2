package com.cee.tech.dao;

import com.cee.tech.app.bean.GenericBeanI;
import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.app.model.entity.TicketManagement;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.database.Database;
import com.cee.tech.database.MySqlDatabase;

import java.util.ArrayList;
import java.util.List;

public class GenericDaoImpl<T> implements GenericDaoI<T> {
    Database database = Database.getDbInstance();

    GenericDaoI<T> genericDaoI = new GenericDaoImpl<>();

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<T> list(Class<?> entity) {

        if (entity.equals(User.class))
            return (List<T>) database.getUsers();

        if (entity.equals(Fixture.class))
            return (List<T>) database.getFixtures();

        if (entity.equals(TicketManagement.class))
            return (List<T>) database.getTicketManagement();


        return new ArrayList<>();
    }



    @Override
    public void addOrUpdate(T entity) {
        genericDaoI.addOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public MySqlDatabase getDatabase() {
        return null;
    }

    @Override
    public void setDatabase(MySqlDatabase database) {

    }
}
