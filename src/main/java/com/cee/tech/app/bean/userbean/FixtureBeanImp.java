package com.cee.tech.app.bean.userbean;

import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.bean.sharedbean.FixtureBeanI;
import com.cee.tech.app.model.entity.Fixture;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless(name = "userFixtureBean")
@Remote
public class FixtureBeanImp extends GenericBeanImpl<Fixture> implements FixtureBeanI, Serializable {

    @Override
    public Fixture addOrUpdate(Fixture fixture) {
       return getDao().addOrUpdate(fixture);
    }
}
