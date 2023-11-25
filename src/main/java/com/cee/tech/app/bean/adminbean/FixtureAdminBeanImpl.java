package com.cee.tech.app.bean.adminbean;

import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.bean.sharedbean.FixtureBeanI;
import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.database.Database;

import javax.ejb.Stateless;
import java.util.List;

public class FixtureAdminBeanImpl extends GenericBeanImpl<Fixture> implements FixtureBeanI {

//    @Override
//    public void addOrUpdate(Fixture fixture) {
//
//         getDao().addOrUpdate(fixture);
//    }
    @Override
    public String upcomingFixtures() {
        List<Fixture> fixtures = Database.getDbInstance().getFixtures();

        StringBuilder tbBuilder = new StringBuilder();


        for(Fixture fixture: fixtures)
            tbBuilder.append(fixture.tableAdminRow());

        return tbBuilder.toString();
    }

    @Override
    public Fixture addUpdateFixture(Fixture fixture) throws Exception {
        return null;
    }

    @Override
    public void deleteFixture(Fixture fixture) {

    }
}
