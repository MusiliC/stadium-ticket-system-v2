package com.cee.tech.app.bean.sharedbean;

import com.cee.tech.app.bean.GenericBeanI;
import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.model.entity.Fixture;

import javax.ejb.Remote;

@Remote
public interface FixtureBeanI extends GenericBeanI<Fixture>  {
    public  String upcomingFixtures();
    public Fixture addUpdateFixture(Fixture fixture) throws  Exception;
    public  void deleteFixture(Fixture fixture);
}
