package com.cee.tech.app.model.entity;

import com.cee.tech.database.helper.DbTable;
import com.cee.tech.database.helper.DbTableColumn;
import com.cee.tech.view.html.*;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EticketHtmlForm(label = "Fixture", url = "./admin", httpMethod = "POST")
@Entity
@Table(name = "fixtures")
public class Fixture extends BaseEntity {


    @EticketFormField(label = "Fixture Type")
    @EticketTableColHeader(headerLabel = "Fixture Type")
    @Column(name = "fixtureType")
    @EticketFixtureCard(cssClass = "fixture")
    @Enumerated(EnumType.STRING)
    private FixtureType fixtureType;

    @EticketFormField(label = "Fixture Time", fieldType = "time")
    @EticketTableColHeader(headerLabel = "Time")
    @Column(name = "fixtureTime")
    @EticketFixtureCard(cssClass = "timeLocation")
    private String fixtureTime;
    @EticketFormField(label = "Fixture Location")
    @EticketTableColHeader(headerLabel = "Location")
    @EticketFixtureCard(cssClass = "timeLocation")
    @Column(name = "fixtureLocation")
    private String fixtureLocation;
    @EticketFormField(label = "Home Team")
    @EticketTableColHeader(headerLabel = "Home Team")
    @Column(name = "homeTeam")
    @EticketFixtureCard(cssClass = "teams")
    private String homeTeam;
    @EticketFormField(label = "Away Team")
    @EticketTableColHeader(headerLabel = "Away Team")
    @Column(name = "awayTeam")
    @EticketFixtureCard(cssClass = "teams")
    private String awayTeam;
    @EticketFormField(label = "Fixture Date", fieldType = "date")
    @EticketTableColHeader(headerLabel = "Date")
    @Column(name = "fixtureDate")
    @EticketFixtureCard(cssClass = "date")
    private String fixtureDate;

    @Transient
    @EticketFormField(label = "Fixture desc id", fieldType = "number", name = "fixtureDescId")
    private int fixtureDescId;

    @OneToOne
    @JoinColumn(name = "fixture_desc_id")
    private TicketManagement ticketManagement;

    @OneToMany(mappedBy = "fixture")
    private List<BookTicket> fixtureTickets = new ArrayList<>();


//    @EticketTableColHeader(headerLabel = "Edit")
//    @Transient
//    private String action = "<img width=\"22\" height=\"22\" src=\"https://img.icons8.com/cotton/64/create-new--v2.png\" alt=\"create-new--v2\"/>";


    public FixtureType getFixtureType() {
        return fixtureType;
    }


    public Fixture(int id, FixtureType fixtureType, String fixtureTime, String fixtureLocation, String homeTeam,
                   String awayTeam, String fixtureDate) {
        setId(id);
        this.fixtureType = fixtureType;
        this.fixtureTime = fixtureTime;
        this.fixtureLocation = fixtureLocation;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.fixtureDate = fixtureDate;
    }

    public String getFixtureTime() {
        return fixtureTime;
    }

    public void setFixtureTime(String fixtureTime) {
        this.fixtureTime = fixtureTime;
    }

    public String getFixtureDate() {
        return fixtureDate;
    }

    public void setFixtureDate(String fixtureDate) {
        this.fixtureDate = fixtureDate;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getFixtureLocation() {
        return fixtureLocation;
    }

    public void setFixtureLocation(String fixtureLocation) {
        this.fixtureLocation = fixtureLocation;
    }

    public void setFixtureType(FixtureType fixtureType) {
        this.fixtureType = fixtureType;
    }

    public TicketManagement getTicketManagement() {
        return ticketManagement;
    }

    public void setTicketManagement(TicketManagement ticketManagement) {
        this.ticketManagement = ticketManagement;
    }

    public Fixture() {
    }

    public int getFixtureDescId() {
        return fixtureDescId;
    }

    public void setFixtureDescId(int fixtureDescId) {
        this.fixtureDescId = fixtureDescId;
    }

    public List<BookTicket> getFixtureTickets() {
        return fixtureTickets;
    }

    public void setFixtureTickets(List<BookTicket> fixtureTickets) {
        this.fixtureTickets = fixtureTickets;
    }

    @Override
    public String toString() {
        return "Fixture{" +
                "fixture id = " + getId() +
                "fixtureType=" + fixtureType +
                ", fixtureTime='" + fixtureTime + '\'' +
                ", fixtureLocation='" + fixtureLocation + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", fixtureDate='" + fixtureDate + '\'' +
                '}';
    }
}
