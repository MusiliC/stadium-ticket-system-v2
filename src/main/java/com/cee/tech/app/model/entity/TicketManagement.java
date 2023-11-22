package com.cee.tech.app.model.entity;

import com.cee.tech.view.html.EticketTableColHeader;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class TicketManagement implements Serializable {
    @EticketTableColHeader(headerLabel = "Fixture Type")
    private TicketType ticketType;
    @EticketTableColHeader(headerLabel = "Total Tickets")
    private int totalTicketsAllocated;
    @EticketTableColHeader(headerLabel = "VIP tickets")
    private int totalVipTicketsLocated;
    @EticketTableColHeader(headerLabel = "VIP Ticket Amount")
    private int ticketAmountVIP;
    @EticketTableColHeader(headerLabel = "Normal Tickets")
    private int totalNormalTicketsAllocated;
    @EticketTableColHeader(headerLabel = "Normal Ticket Amount")
    private int ticketAmountNormal;

    @EticketTableColHeader(headerLabel = "Action")
    private String action = "Edit";

    public TicketManagement() {
    }

    public TicketManagement(int totalTicketsAllocated, int totalVipTicketsLocated, int ticketAmountVIP, int totalNormalTicketsAllocated, int ticketAmountNormal) {

        this.totalTicketsAllocated = totalTicketsAllocated;
        this.totalVipTicketsLocated = totalVipTicketsLocated;
        this.ticketAmountVIP = ticketAmountVIP;
        this.totalNormalTicketsAllocated = totalNormalTicketsAllocated;
        this.ticketAmountNormal = ticketAmountNormal;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
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


}
