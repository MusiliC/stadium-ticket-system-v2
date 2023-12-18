package com.cee.tech.dao;

import com.cee.tech.database.MySqlDatabase;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public interface GenericDaoI<T> extends Serializable {

    List<T> list(Object entity);

    List<Object[]> nativeQuery(String sql);

    T fetchSingle(Class<?> entity, int id);

    T addOrUpdate(T entity);

    void delete(Class<?> klass, int id);

    EntityManager getEm();

    void setEm(EntityManager em);

}