package com.cee.tech.app.model.entity;


import com.cee.tech.database.helper.DbTable;
import com.cee.tech.database.helper.DbTableColumn;
import com.cee.tech.view.html.EticketTableColHeader;
import com.cee.tech.view.html.TableActions;

import java.io.Serializable;

@DbTable(name = "users")
public class User extends BaseEntity {

    @DbTableColumn(name = "username", notNull = "not null")
    @EticketTableColHeader(headerLabel = "Username")
    private String username;
    @DbTableColumn(name = "password", notNull = "not null")
    private String password;
    private String confirmPassword;


    @DbTableColumn(name = "normalTickets", definition = "int")
    @EticketTableColHeader(headerLabel = "Normal Ticket")
    private int normalTickets = 0;
    @DbTableColumn(name = "vipTickets", definition = "int")
    @EticketTableColHeader(headerLabel = "VIP Ticket")
    private int vipTickets = 0;

    @EticketTableColHeader(headerLabel = "Actions")
    @TableActions(actions = "Edit")
    private String actions;


    public int getNormalTickets() {
        return normalTickets;
    }

    public void setNormalTickets(int normalTickets) {
        this.normalTickets = normalTickets;
    }

    public int getVipTickets() {
        return vipTickets;
    }

    public void setVipTickets(int vipTickets) {
        this.vipTickets = vipTickets;
    }

    public User() {
    }

    public User(int id, String username, String password) {
        setId(id);
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password, int normalTickets, int vipTickets) {
        setId(id);
        this.username = username;
        this.password = password;
        this.normalTickets = normalTickets;
        this.vipTickets = vipTickets;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", normalTickets=" + normalTickets +
                ", vipTickets=" + vipTickets +
                ", actions='" + actions + '\'' +
                '}';
    }
}
