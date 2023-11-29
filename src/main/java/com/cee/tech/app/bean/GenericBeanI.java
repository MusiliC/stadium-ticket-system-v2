package com.cee.tech.app.bean;

import java.io.Serializable;
import java.util.List;

public interface GenericBeanI<T> extends Serializable {

    List<T> list(Class<?> entity);

    T selectSingle(Class<?> entity, int id);

     void addOrUpdate(T entity);

    void delete(T entity);
}
