package com.cee.tech.app.bean.sharedbean;

import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.bean.userbean.UserBeanI;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.utils.HashText;
import com.cee.tech.view.html.HtmlComponents;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

@Remote
@Stateless
public class UserBeanImpl extends GenericBeanImpl<User> implements UserBeanI {

    @Inject
    private HashText hashText;

    @PersistenceContext
    EntityManager em;


    @Override
    public boolean registerUser(User user) throws SQLException {

        if (!user.getPassword().equals(user.getConfirmPassword()))
            throw new RuntimeException("Password & confirm password do not match");

        //1. check if username already exist

//        List<User> users = list(user.getClass());
//        if (!users.isEmpty())
//            throw new RuntimeException("User already exists!");
        //2. hash password

        try {
            user.setPassword(hashText.hash(user.getPassword()));
        } catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }

        //3. initiate event to send email ...Observer design pattern

        getDao().addOrUpdate(user);

        return false;

    };

    @Override
    public List<User> list(Object entity) {

        return em.createQuery("FROM User u",User.class).getResultList() ;
    }

    @Override
    public boolean unregisterUser(User user) {
    return false;
    }



}
