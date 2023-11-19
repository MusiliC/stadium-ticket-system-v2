package com.cee.tech.app.bean.userbean;

import com.cee.tech.app.bean.sharedbean.FixtureBeanI;
import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.database.Database;

import java.io.Serializable;
import java.util.List;

public class FixtureBean implements FixtureBeanI, Serializable {
    public  String upcomingFixtures(){
        List<Fixture> fixtures = Database.getDbInstance().getFixtures();

        StringBuilder tbBuilder = new StringBuilder();


        for(Fixture fixture: fixtures)
            tbBuilder.append(fixture.tableRow());

        return tbBuilder.toString();
    };
    public Fixture addUpdateFixture(Fixture fixture)throws  Exception{
      return  fixture;
    };

    public  void deleteFixture(Fixture fixture){
        System.out.println("Yaay");
    }
}
