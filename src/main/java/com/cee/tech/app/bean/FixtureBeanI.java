package com.cee.tech.app.bean;

import com.cee.tech.app.model.entity.Fixture;

public interface FixtureBeanI {
    public  String upcomingFixtures();
    public Fixture addUpdateFixture(Fixture fixture) throws  Exception;
    public  void deleteFixture(Fixture fixture);
}
