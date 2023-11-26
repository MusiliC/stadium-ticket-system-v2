package com.cee.tech.app.bean;

import com.cee.tech.dao.GenericDaoI;
import com.cee.tech.dao.GenericDaoImpl;

import java.util.List;

public class GenericBeanImpl<T> implements GenericBeanI<T> {

    GenericDaoI<T> genericDaoI = new GenericDaoImpl<>();

    @Override

    public List<T> list(Class<?> entity) {
        return genericDaoI.list(entity);
    }


    @Override
    public T addOrUpdate(T entity) {
        return null;
    }

    @Override
    public void delete(T entity) {

    }
}
