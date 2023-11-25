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
    @EticketFormField
    @DbTableColumn(name = "email")
    private String email;
    @EticketFormField(label = "Phone Number")
    @DbTableColumn(name = "number", notNull = "not null")
    private String phoneNumber;
    @EticketFormField(label="Ticket Type")
    @DbTableColumn(name = "ticketType", notNull = "not null")
    private TicketType ticketType;
    @EticketFormField(label= "Number of Tickets", fieldType = "number")
    @DbTableColumn(name = "totalTickets", notNull = "not null")
    private int numberOfTickets;

//    @DbTableColumn(name = "userId", notNull = "not null", foreignKeyColumn = "FOREIGN KEY", references = "REFERENCES", referenceTo = "users(id)")
//    private int userId;

    public BookTicket() {
    }

//    public BookTicket(String name, String email, String phoneNumber, TicketType ticketType, int numberOfTickets, int userId) {
//        this.name = name;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.ticketType = ticketType;
//        this.numberOfTickets = numberOfTickets;
//        this.userId = userId;
//    }

    public BookTicket(int id,String name, String email, String phoneNumber, int numberOfTickets) {
        setId(id);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.numberOfTickets = numberOfTickets;
    }

//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }

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


}
