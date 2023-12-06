package com.cee.tech.dao;

import com.cee.tech.database.MySqlDatabase;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public interface GenericDaoI <T> extends Serializable {

    List<T> list(Object entity);

    T fetchSingle(Class<?> entity, int id);
    void addOrUpdate(T entity);

    void delete(T entity);

    EntityManager getEm();

    void setEm(EntityManager em);

}