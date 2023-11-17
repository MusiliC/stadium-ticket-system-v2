package com.cee.tech.app.model.entity;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class User implements Serializable {
    private  String id;
    private String username;
    private String password;
    private  String confirmPassword;

    private int normalTickets = 0;
    private int vipTickets = 0;


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

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String id, String username, String password, int normalTickets, int vipTickets) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.normalTickets = normalTickets;
        this.vipTickets = vipTickets;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String UserDataTable(){
        StringBuilder tbBuilder = new StringBuilder();

        tbBuilder.append("<tr>");
        tbBuilder.append("<td>").append(StringUtils.trimToEmpty(getUsername())).append("</td>");
        tbBuilder.append("<td>").append(getVipTickets()).append("</td>");
        tbBuilder.append("<td>").append(getNormalTickets()).append("</td>");
        tbBuilder.append("<td>");
        tbBuilder.append(" <div class=\"userOutlineButton\">Details</div>");
        tbBuilder.append("</td>");
        tbBuilder.append("</tr>");

        return  tbBuilder.toString();

    };
}
