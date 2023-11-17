package com.cee.tech.app.model.entity;

import com.cee.tech.view.html.EticketFormField;
import com.cee.tech.view.html.EticketHtmlForm;

import java.io.Serializable;
@EticketHtmlForm(label = "Ticket", url = "./#")
public class Ticket implements Serializable {
    @EticketFormField
    private String name;
    @EticketFormField
    private String email;
    @EticketFormField(label = "Phone Number")
    private String phoneNumber;
    @EticketFormField(label="Ticket Type")
    private String ticketType;
    @EticketFormField(label= "Number of Tickets", fieldType = "number")
    private int numberOfTickets;

    public Ticket() {
    }

    public Ticket(String name, String email, String phoneNumber, String ticketType, int numberOfTickets) {
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

    public String ticketCard(){
        StringBuilder cardBuilder = new StringBuilder();



        return  cardBuilder.toString();
    }
}
