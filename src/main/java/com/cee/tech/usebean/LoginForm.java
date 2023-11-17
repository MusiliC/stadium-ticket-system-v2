package com.cee.tech.usebean;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

public class LoginForm implements Serializable {

    private String usernamePlaceholder = "Enter username";
    private String passwordPlaceholder = "Enter password" ;
    private String timeToLogin = null;
    

    public String getUsernamePlaceholder() {
        return usernamePlaceholder;
    }
    public void setUsernamePlaceholder(String usernamePlaceholder) {
        this.usernamePlaceholder = usernamePlaceholder;
    }
    public String getPasswordPlaceholder() {
        return passwordPlaceholder;
    }
    public void setPasswordPlaceholder(String passwordPlaceholder) {
        this.passwordPlaceholder = passwordPlaceholder;
    }
    public String getTimeToLogin() {
          if(timeToLogin == null)
            timeToLogin = DateFormat.getDateTimeInstance().format(new Date());
        return timeToLogin;
    }
    public void setTimeToLogin(String timeToLogin) {
      
        this.timeToLogin = timeToLogin;
    }

    
}
