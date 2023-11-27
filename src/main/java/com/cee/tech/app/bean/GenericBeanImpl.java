package com.cee.tech.app.bean;

import com.cee.tech.dao.GenericDaoI;
import com.cee.tech.dao.GenericDaoImpl;

import java.util.List;

public class GenericBeanImpl<T> implements GenericBeanI<T> {

   private final GenericDaoI<T> genericDaoI = new GenericDaoImpl<>();

    @Override
    public List<T> list(Class<?> entity) {
        return genericDaoI.list(entity);
    }


    @Override
    public void addOrUpdate(T entity) {

        genericDaoI.addOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {

    }

    public  GenericDaoImpl<T> getDao(){
        return (GenericDaoImpl<T>) genericDaoI;
    }

//    public GenericDaoImpl<T> getDao(){
//        genericDaoI.setDatabase(database);
//        return (GenericDaoImpl<T>) <T>) genericDaoI;
//    }
}
