package com.cee.tech.app.model.entity;

import com.cee.tech.database.helper.DbTable;
import com.cee.tech.database.helper.DbTableColumn;
import com.cee.tech.view.html.EticketTableColHeader;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@DbTable(name = "ticketManagement")
public class TicketManagement extends BaseEntity {
    @EticketTableColHeader(headerLabel = "Fixture Type")
    @DbTableColumn(name = "fixtureType", notNull = "not null")
    private String fixtureType;
    @EticketTableColHeader(headerLabel = "Total Tickets")
    @DbTableColumn(name = "totalTickets", notNull = "not null", definition = "int")
    private int totalTicketsAllocated;
    @EticketTableColHeader(headerLabel = "VIP tickets")
    @DbTableColumn(name = "totalVip", notNull = "not null", definition = "int")
    private int totalVipTicketsLocated;
    @EticketTableColHeader(headerLabel = "VIP Ticket Amount")
    @DbTableColumn(name = "vipAmount", notNull = "not null", definition = "int")
    private int ticketAmountVIP;
    @EticketTableColHeader(headerLabel = "Normal Tickets")
    @DbTableColumn(name = "totalNormal", notNull = "not null", definition="int")
    private int totalNormalTicketsAllocated;
    @EticketTableColHeader(headerLabel = "Normal Ticket Amount")
    @DbTableColumn(name = "normalAmount", notNull = "not null", definition = "int")
    private int ticketAmountNormal;

    @EticketTableColHeader(headerLabel = "Action")
    private String action = "Edit";

    public TicketManagement() {
    }

    public TicketManagement(int id,String fixtureType, int totalTicketsAllocated, int totalVipTicketsLocated, int ticketAmountVIP, int totalNormalTicketsAllocated, int ticketAmountNormal) {
        setId(id);
        this.fixtureType = fixtureType;
        this.totalTicketsAllocated = totalTicketsAllocated;
        this.totalVipTicketsLocated = totalVipTicketsLocated;
        this.ticketAmountVIP = ticketAmountVIP;
        this.totalNormalTicketsAllocated = totalNormalTicketsAllocated;
        this.ticketAmountNormal = ticketAmountNormal;
    }

    public String getFixtureType() {
        return fixtureType;
    }

    public void setFixtureType(String fixtureType) {
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
