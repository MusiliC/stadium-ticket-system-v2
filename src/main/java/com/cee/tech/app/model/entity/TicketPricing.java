package com.cee.tech.app.model.entity;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class TicketPricing implements Serializable {
    private String ticketType;
    private int ticketAmountNormal;

    private int ticketAmountVIP;

    public TicketPricing() {
    }

    public TicketPricing(String ticketType,  int ticketAmountVIP,int ticketAmountNormal) {
        this.ticketType = ticketType;
        this.ticketAmountNormal = ticketAmountNormal;
        this.ticketAmountVIP = ticketAmountVIP;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getTicketAmountNormal() {
        return ticketAmountNormal;
    }

    public void setTicketAmountNormal(int ticketAmountNormal) {
        this.ticketAmountNormal = ticketAmountNormal;
    }

    public int getTicketAmountVIP() {
        return ticketAmountVIP;
    }

    public void setTicketAmountVIP(int ticketAmountVIP) {
        this.ticketAmountVIP = ticketAmountVIP;
    }

    public String ticketPricingTableRow(){
        StringBuilder tbBuilder = new StringBuilder();


        tbBuilder.append("<tr>");
        tbBuilder.append("<td>").append(StringUtils.trimToEmpty(getTicketType())).append("</td>");
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
