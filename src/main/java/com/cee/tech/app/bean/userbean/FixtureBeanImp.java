package com.cee.tech.app.bean.userbean;

import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.bean.sharedbean.FixtureBeanI;
import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.database.Database;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;
@Stateless(name = "userFixtureBean")
@Remote
public class FixtureBeanImp extends GenericBeanImpl<Fixture> implements FixtureBeanI, Serializable {


    public  String upcomingFixtures(){
        List<Fixture> fixtures = Database.getDbInstance().getFixtures();

        StringBuilder tbBuilder = new StringBuilder();


        for(Fixture fixture: fixtures)
            tbBuilder.append(fixture.tableRow());

        return tbBuilder.toString();
    };





}
