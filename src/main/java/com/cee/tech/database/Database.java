package com.cee.tech.database;

import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.app.model.entity.Ticket;
import com.cee.tech.app.model.entity.TicketManagement;
import com.cee.tech.app.model.entity.User;

import java.io.Serializable;
import java.sql.Connection;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Database implements Serializable {

    private  static  Database dbInstance;

    private Connection connection;

    private  Database(){};
    private List<Object> data = new ArrayList<>();

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private  String databaseCreatedAt;

    public  static Database getDbInstance(){
        if(dbInstance == null) {
            dbInstance = new Database();
            dbInstance.databaseCreatedAt = DateFormat.getTimeInstance().format(new Date());
            System.out.println( "DB created at: " + dbInstance.getDatabaseCreatedAt());
        }
        return  dbInstance;
    }
    public String getDatabaseCreatedAt() {
        return databaseCreatedAt;
    }



    public List<Object> getData(Class <?> clazz) {
        return data
                .stream()
                .filter(clazz::isInstance)
                .collect(Collectors.toList());
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    private List<User> users = new ArrayList<>();
    private  List<Fixture> fixtures = new ArrayList<>();

    private List<TicketManagement> ticketManagement = new ArrayList<>();

    private List<Ticket> bookTicket = new ArrayList<>();

    public List<Ticket> getBookTicket() {
        return bookTicket;
    }

    public void setBookTicket(List<Ticket> bookTicket) {
        this.bookTicket = bookTicket;
    }

    public List<TicketManagement> getTicketManagement() {
        return ticketManagement;
    }

    public void setTicketManagement(List<TicketManagement> ticketManagement) {
        this.ticketManagement = ticketManagement;
    }

    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


}
