package com.cee.tech.app.bean.adminbean;

import com.cee.tech.app.bean.FixtureBeanI;
import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.database.Database;

import java.util.List;

public class FixtureAdminBean implements FixtureBeanI {
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
