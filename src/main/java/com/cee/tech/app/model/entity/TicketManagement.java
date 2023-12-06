package com.cee.tech.app.model.entity;

import com.cee.tech.database.helper.DbTable;
import com.cee.tech.database.helper.DbTableColumn;
import com.cee.tech.view.html.EticketFormField;
import com.cee.tech.view.html.EticketHtmlForm;
import com.cee.tech.view.html.EticketTableColHeader;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "ticketManagement")
@EticketHtmlForm(label = "TicketManagement", url = "./adminticketpricing", httpMethod = "POST")
public class TicketManagement extends BaseEntity {
    @EticketTableColHeader(headerLabel = "Fixture Type")
    @Column(name = "fixtureType")
    @EticketFormField(label = "Fixture Type")
    @Enumerated(EnumType.STRING)
    private FixtureType fixtureType;
    @EticketTableColHeader(headerLabel = "Total Tickets")
    @Column(name = "totalTickets")
    @EticketFormField(label = "Total Tickets Allocated: ", fieldType = "number")
    private int totalTicketsAllocated;
    @EticketTableColHeader(headerLabel = "VIP tickets")
    @Column(name = "totalVip")
    @EticketFormField(label = "Total VIP tickets: ", fieldType = "number")
    private int totalVipTicketsLocated;
    @EticketTableColHeader(headerLabel = "VIP Ticket Amount")
    @Column(name = "vipAmount")
    @EticketFormField(label = "VIP ticket amount: ", fieldType = "number")
    private int ticketAmountVIP;
    @EticketTableColHeader(headerLabel = "Normal Tickets")
    @Column(name = "totalNormal")
    @EticketFormField(label = "Total Normal tickets: ", fieldType = "number")
    private int totalNormalTicketsAllocated;
    @EticketTableColHeader(headerLabel = "Normal Ticket Amount")
    @Column(name = "normalAmount")
    @EticketFormField(label = "Normal ticket amount: ", fieldType = "number")
    private int ticketAmountNormal;

    @EticketTableColHeader(headerLabel = "Edit")
    private String action = "<img width=\"22\" height=\"22\" src=\"https://img.icons8.com/cotton/64/create-new--v2.png\" alt=\"create-new--v2\"/>";

    public TicketManagement() {
    }

    public TicketManagement(int id,FixtureType fixtureType, int totalTicketsAllocated, int totalVipTicketsLocated, int ticketAmountVIP, int totalNormalTicketsAllocated, int ticketAmountNormal) {
        setId(id);
        this.fixtureType = fixtureType;
        this.totalTicketsAllocated = totalTicketsAllocated;
        this.totalVipTicketsLocated = totalVipTicketsLocated;
        this.ticketAmountVIP = ticketAmountVIP;
        this.totalNormalTicketsAllocated = totalNormalTicketsAllocated;
        this.ticketAmountNormal = ticketAmountNormal;
    }

    public FixtureType getFixtureType() {
        return fixtureType;
    }

    public void setFixtureType(FixtureType fixtureType) {
        this.fixtureType = fixtureType;
    }

    public int getTotalTicketsAllocated() {
        return totalTicketsAllocated;
    }

    public void setTotalTicketsAllocated(int totalTicketsAllocated) {
        this.totalTicketsAllocated = totalTicketsAllocated;
    }

    public int getTotalVipTicketsLocated() {
        return totalVipTicketsLocated;
    }

    public void setTotalVipTicketsLocated(int totalVipTicketsLocated) {
        this.totalVipTicketsLocated = totalVipTicketsLocated;
    }

    public int getTicketAmountVIP() {
        return ticketAmountVIP;
    }

    public void setTicketAmountVIP(int ticketAmountVIP) {
        this.ticketAmountVIP = ticketAmountVIP;
    }

    public int getTotalNormalTicketsAllocated() {
        return totalNormalTicketsAllocated;
    }

    public void setTotalNormalTicketsAllocated(int totalNormalTicketsAllocated) {
        this.totalNormalTicketsAllocated = totalNormalTicketsAllocated;
    }

    public int getTicketAmountNormal() {
        return ticketAmountNormal;
    }

    public void setTicketAmountNormal(int ticketAmountNormal) {
        this.ticketAmountNormal = ticketAmountNormal;
    }


    public String ticketPricingTableRow(){
        StringBuilder tbBuilder = new StringBuilder();


        tbBuilder.append("<tr>");
        //tbBuilder.append("<td>").append(StringUtils.trimToEmpty(getTicketType())).append("</td>");
        tbBuilder.append("<td>").append(getTicketAmountVIP()).append("</td>");
        tbBuilder.append("<td>").append(getTicketAmountNormal()).append("</td>");
        tbBuilder.append("<td>");
        tbBuilder.append("<div class=\"homeButtons\">");
        tbBuilder.append("<a href=\"./#\" class=\"homeOutlineButton\" >Edit</a>");
        tbBuilder.append("<a href=\"./#\" class=\"homeNormalButton\">Delete</a>");
        tbBuilder.append("</div>");
        tbBuilder.append("</td>");
        tbBuilder.append("</tr>");

        return tbBuilder.toString();

    }

    @Override
    public String toString() {
        return "TicketManagement{" +
                "fixtureType='" + fixtureType + '\'' +
                ", totalTicketsAllocated=" + totalTicketsAllocated +
                ", totalVipTicketsLocated=" + totalVipTicketsLocated +
                ", ticketAmountVIP=" + ticketAmountVIP +
                ", totalNormalTicketsAllocated=" + totalNormalTicketsAllocated +
                ", ticketAmountNormal=" + ticketAmountNormal +
                ", action='" + action + '\'' +
                '}';
    }
}
