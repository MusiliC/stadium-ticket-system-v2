package com.cee.tech.app.bean;

import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.database.Database;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericBeanImpl<T> implements  GenericBeanI<T>{

    Database database = Database.getDbInstance();

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<T> list() {
        Class clazz = ((Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);

        if (clazz.equals(Fixture.class))
            return (List<T>) database.getFixtures();
        return null;
    }

    @Override
    public Object create(Object entity) {
        return null;
    }

    @Override
    public Object update(Object entity) {
        return null;
    }

    @Override
    public void delete(Object entity) {

    }
}
