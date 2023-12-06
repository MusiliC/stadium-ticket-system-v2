package com.cee.tech.app.model.entity;

import com.cee.tech.database.helper.DbTable;
import com.cee.tech.database.helper.DbTableColumn;
import com.cee.tech.view.html.EticketFormField;
import com.cee.tech.view.html.EticketHtmlCard;
import com.cee.tech.view.html.EticketHtmlForm;

import javax.persistence.*;


@Entity
@Table(name = "bookTicket")
@EticketHtmlForm(label = "Ticket", url = "./book")
public class BookTicket extends BaseEntity {
    @EticketFormField(name = "name")
    @Column(name = "name")
    private String name;

    @Column(name = "ticketNumber")
    @EticketHtmlCard(cssClass = "ticketNumber")
    private String ticketNumber;

    @EticketHtmlCard(cssClass = "ticketFixtureType")
    @Transient
    private String fixtureType = "CAF Champions League";

    @EticketHtmlCard(cssClass = "newTicketInfoDetails", pTag = "bookTicketHomeTeam")
    @Transient
    private String homeTeam = "Gor Mahia";
    @EticketHtmlCard(cssClass = "newTicketInfoDetails", pTag = "bookTicketAwayTeam")
    @Transient
    private String awayTeam = "AFC Leopards";
    @EticketFormField(name = "email")
    @Column(name = "email")
    private String email;
    @EticketFormField(label = "Phone Number", name = "phoneNumber")
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @EticketFormField(label = "Ticket Type", name = "ticketType")
    @Column(name = "ticketType")
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    @EticketHtmlCard(cssClass = "ticketDate")
    @Transient
    private String date = "2023/11/11";
    @EticketFormField(label = "Number of Tickets", fieldType = "number", name = "numberOfTickets")
    //@DbTableColumn(name = "totalTickets", notNull = "not null", definition = "int")
    @Column(name = "totalTickets")
    private int numberOfTickets;


    public BookTicket() {
    }


    public BookTicket(int id, String ticketNumber, String name, String email, String phoneNumber, TicketType ticketType, int numberOfTickets) {
        setId(id);
        this.ticketNumber = ticketNumber;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.ticketType = ticketType;
        this.numberOfTickets = numberOfTickets;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
