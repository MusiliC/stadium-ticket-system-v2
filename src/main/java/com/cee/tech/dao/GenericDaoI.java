package com.cee.tech.dao;

import com.cee.tech.database.MySqlDatabase;

import java.io.Serializable;
import java.util.List;

public interface GenericDaoI <T> extends Serializable {

    List<T> list(Class<?> entity);

    void addOrUpdate(T entity);

    void delete(T entity);

    MySqlDatabase getDatabase();

    void setDatabase(MySqlDatabase database);

}