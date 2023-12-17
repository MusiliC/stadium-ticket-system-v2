package com.cee.tech.app.bean;

import java.io.Serializable;
import java.util.List;

public interface GenericBeanI<T> extends Serializable {

    List<T> list(Object entity);

    T selectSingle(Class<?> entity, int id);

     T addOrUpdate(T entity);

    void delete(Class<?> entity, int id);
}
