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
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Remote
@Stateless
public class AuthBeanImpl extends GenericBeanImpl<User> implements Serializable, AuthBeanI {

    @EJB
    MySqlDatabase mySqlDatabase;

    @Inject
    private HashText hashText;
    User userDetails = null;

    @Inject
    private Event<Audit> logger;
    public User authenticateUser(User loginUser) throws SQLException {

        try {
            loginUser.setPassword(hashText.hash(loginUser.getPassword()));
        } catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }

        List<User> users = list(loginUser);

        if (users.isEmpty() || users.get(0) == null)
            throw new RuntimeException("Invalid user!!");


        Audit log = new Audit();
        log.setLogdetails("User logged in at: " + DateFormat.getDateTimeInstance().format(new Date()) + ", " + users.get(0).getUsername());

        logger.fire(log);

        return users.get(0);
    }
}
