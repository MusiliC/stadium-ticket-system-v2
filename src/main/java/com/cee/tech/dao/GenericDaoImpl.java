package com.cee.tech.dao;

import com.cee.tech.app.bean.GenericBeanI;
import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.app.model.entity.TicketManagement;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.database.Database;
import com.cee.tech.database.MySqlDatabase;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class GenericDaoImpl<T> implements GenericDaoI<T> {

    private EntityManager em;

    @SuppressWarnings({"unchecked"})
    @Override
    public List<T> list(Object entity) {
        String jpql  = "FROM " + entity.getClass().getSimpleName() + " e";

        List<T> results = (List<T>) em.createQuery(jpql, entity.getClass()).getResultList();

        return results;

    }

    @Override
    public T fetchSingle(Class<?> entity, int id) {
        return null;
    }

    @Override
    public void addOrUpdate(T entity) {
        em.merge(entity);
    }

    @Override
    public void delete(T entity) {

    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }


}
