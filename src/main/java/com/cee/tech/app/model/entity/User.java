package com.cee.tech.app.model.entity;



import com.cee.tech.view.html.EticketTableColHeader;
import com.cee.tech.view.html.TableActions;

import java.io.Serializable;

public class User implements Serializable {

    private  int id;
    @EticketTableColHeader(headerLabel = "Username")
    private String username;
    private String password;
    private  String confirmPassword;

    @EticketTableColHeader(headerLabel  = "Normal Ticket")
    private int normalTickets = 0;
    @EticketTableColHeader(headerLabel  = "VIP Ticket")
    private int vipTickets = 0;

    @EticketTableColHeader(headerLabel  = "Actions")
    @TableActions(actions={"Delete", "Edit"})
    private String actions[];


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
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password, int normalTickets, int vipTickets) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.normalTickets = normalTickets;
        this.vipTickets = vipTickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


}
