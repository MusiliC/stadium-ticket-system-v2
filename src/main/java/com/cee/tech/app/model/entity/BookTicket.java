package com.cee.tech.app.model.entity;

import com.cee.tech.database.helper.DbTable;
import com.cee.tech.database.helper.DbTableColumn;
import com.cee.tech.view.html.EticketFormField;
import com.cee.tech.view.html.EticketHtmlCard;
import com.cee.tech.view.html.EticketHtmlForm;

@DbTable(name = "bookTicket")
@EticketHtmlForm(label = "Ticket", url = "./book")
public class BookTicket extends BaseEntity {
    @EticketFormField(name = "name")
    @DbTableColumn(name = "name", notNull = "not null")
    private String name;

    @DbTableColumn(name = "ticketNumber", notNull = "not null")
    @EticketHtmlCard(cssClass = "ticketNumber")
    private String ticketNumber;

    @EticketHtmlCard(cssClass = "ticketFixtureType")
    private String fixtureType = "CAF Champions League";

    @EticketHtmlCard(cssClass = "newTicketInfoDetails", pTag = "bookTicketHomeTeam")
    private String homeTeam = "Gor Mahia";
    @EticketHtmlCard(cssClass = "newTicketInfoDetails", pTag = "bookTicketAwayTeam")
    private  String awayTeam = "AFC Leopards";
    @EticketFormField(name = "email")
    @DbTableColumn(name = "email")

    private String email;
    @EticketFormField(label = "Phone Number", name = "phoneNumber")
    @DbTableColumn(name = "phoneNumber", notNull = "not null")
    private String phoneNumber;
    @EticketFormField(label="Ticket Type", name = "ticketType")
    @DbTableColumn(name = "ticketType", notNull = "not null")
    private String ticketType;
    @EticketHtmlCard(cssClass = "ticketDate")
    private String date = "2023/11/11";
    @EticketFormField(label= "Number of Tickets", fieldType = "number", name = "numberOfTickets")
    @DbTableColumn(name = "totalTickets", notNull = "not null", definition = "int")
    private int numberOfTickets;





    public BookTicket() {
    }




    public BookTicket(int id,String ticketNumber, String name, String email, String phoneNumber, String ticketType, int numberOfTickets) {
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

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
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
