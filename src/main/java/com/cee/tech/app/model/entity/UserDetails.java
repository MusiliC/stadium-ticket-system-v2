package com.cee.tech.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserDetails implements Serializable {

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_number")
    private String userNumber;
}
