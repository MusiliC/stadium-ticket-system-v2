package com.cee.tech.app.model.entity;

import com.cee.tech.view.html.EticketTableColHeader;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

//@DbTable(name = "users")
@Entity
@Table(name = "users")

public class User extends BaseEntity {


    @EticketTableColHeader(headerLabel = "Username")
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
    @Transient
    private String confirmPassword;


    @EticketTableColHeader(headerLabel = "Normal Ticket")
    @Column(name = "normalTickets")
    private int normalTickets = 0;

    @Column(name = "vipTickets")
    @EticketTableColHeader(headerLabel = "VIP Ticket")
    private int vipTickets = 0;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BookTicket> myTickets = new ArrayList<>();




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


    public List<BookTicket> getMyTickets() {
        return myTickets;
    }

    public void setMyTickets(List<BookTicket> myTickets) {
        this.myTickets = myTickets;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", normalTickets=" + normalTickets +
                ", vipTickets=" + vipTickets +
//                ", myTickets=" + myTickets +
                '}';
    }
}
