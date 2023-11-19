package com.cee.tech.app.bean;

import java.io.Serializable;
import java.util.List;

public interface GenericBeanI<T> extends Serializable {

    String list(Class<?> entity);

     T addOrUpdate(T entity);

    void delete(T entity);
}
