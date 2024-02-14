package com.cee.tech.app.bean;

import com.cee.tech.dao.GenericDaoI;
import com.cee.tech.dao.GenericDaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class GenericBeanImpl<T> implements GenericBeanI<T> {

    @PersistenceContext
    private EntityManager em;

   private final GenericDaoI<T> genericDaoI = new GenericDaoImpl<>();

    @Override
    public List<T> list(Object entity) {
        genericDaoI.setEm(em);
        return genericDaoI.list(entity);
    }

    @Override
    public T selectSingle(Class<?> entity, int id) {
        genericDaoI.setEm(em);
        return genericDaoI.fetchSingle(entity, id);
    }

    @Override
    public  T addOrUpdate(T entity) {
        genericDaoI.setEm(em);
       return genericDaoI.addOrUpdate(entity);
    }



    @Override
    public void delete(Class<?> entity, int id) {
        genericDaoI.setEm(em);
         genericDaoI.delete(entity, id);

    }

    public GenericDaoImpl<T> getDao(){
        genericDaoI.setEm(em);
        return (GenericDaoImpl<T>)  genericDaoI;
    }
}
