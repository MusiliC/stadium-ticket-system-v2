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
    private MySqlDatabase database;

    @Override
    public List<T> list(Class<?> entity) {
        return null;
    }

    @Override
    public void addOrUpdate(T entity) {
        database.saveOrUpdate(entity);
    }
    @Override
    public void delete(T entity) {

    }

    public MySqlDatabase getDatabase() {
        return database;
    }

    public void setDatabase(MySqlDatabase database) {
        this.database = database;
    }
}
