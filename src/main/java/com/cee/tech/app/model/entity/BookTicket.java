package com.cee.tech.app.model.entity;

import com.cee.tech.database.helper.DbTable;
import com.cee.tech.database.helper.DbTableColumn;
import com.cee.tech.view.html.EticketFormField;
import com.cee.tech.view.html.EticketHtmlForm;

@DbTable(name = "bookTicket")
@EticketHtmlForm(label = "Ticket", url = "./#")
public class BookTicket extends BaseEntity {
    @EticketFormField
    @DbTableColumn(name = "name", notNull = "not null")
    private String name;

    @DbTableColumn(name = "ticketNumber", notNull = "not null")
    private String ticketNumber;
    @EticketFormField
    @DbTableColumn(name = "email")
    private String email;
    @EticketFormField(label = "Phone Number")
    @DbTableColumn(name = "number", notNull = "not null")
    private String phoneNumber;
    @EticketFormField(label="Ticket Type")
    @DbTableColumn(name = "ticketType", notNull = "not null")
    private String ticketType;
    @EticketFormField(label= "Number of Tickets", fieldType = "number")
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
