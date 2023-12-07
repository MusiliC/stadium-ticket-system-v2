package com.cee.tech.app.bean.sharedbean;

import com.cee.tech.app.bean.GenericBeanI;
import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.model.entity.Fixture;

import javax.ejb.Remote;

@Remote
public interface FixtureBeanI extends GenericBeanI<Fixture>  {

}
