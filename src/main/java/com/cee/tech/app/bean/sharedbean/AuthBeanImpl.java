package com.cee.tech.app.bean.sharedbean;
import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.model.entity.Audit;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.database.MySqlDatabase;
import com.cee.tech.utils.HashText;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Remote
@Stateless
public class AuthBeanImpl extends GenericBeanImpl<User> implements Serializable, AuthBeanI {



    @PersistenceContext
    EntityManager em;

    @Inject
    private HashText hashText;
    User userDetails = null;

    @Inject
    private Event<Audit> logger;
    public User authenticateUser(User loginUser) throws SQLException {

//        try {
//            loginUser.setPassword(hashText.hash(loginUser.getPassword()));
//        } catch (Exception ex){
//            throw new RuntimeException(ex.getMessage());
//        }
//
//        System.out.println("***************Login User ***************" + loginUser);
//
//
//        List<User> users = list(loginUser);

        try {
            loginUser.setPassword(hashText.hash(loginUser.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        User userLoggedIn =  em.createQuery("FROM User u WHERE u.password=:password AND u.username=:username", User.class)
                .setParameter("password", loginUser.getPassword())
                .setParameter("username", loginUser.getUsername()).getSingleResult();

        if (userLoggedIn == null)
            throw new RuntimeException("Invalid user!!");


        Audit log = new Audit();
        log.setLogdetails("User logged in at: " + DateFormat.getDateTimeInstance().format(new Date()) + ", " + userLoggedIn.getUsername());

        logger.fire(log);

        return userLoggedIn;
    }
}
