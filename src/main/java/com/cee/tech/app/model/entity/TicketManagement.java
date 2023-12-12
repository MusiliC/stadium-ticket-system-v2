package com.cee.tech.app.model.entity;


import com.cee.tech.view.html.EticketFormField;
import com.cee.tech.view.html.EticketHtmlForm;
import com.cee.tech.view.html.EticketTableColHeader;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Formula;

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
    private int totalTickets;
    @EticketTableColHeader(headerLabel = "VIP tickets")
    @Column(name = "totalVip")
    @EticketFormField(label = "Total VIP tickets: ", fieldType = "number")
    private int totalVip;
    @EticketTableColHeader(headerLabel = "VIP Ticket Amount")
    @Column(name = "vipAmount")
    @EticketFormField(label = "VIP ticket amount: ", fieldType = "number")
    private int vipAmount;
    @EticketTableColHeader(headerLabel = "Normal Tickets")
    @Column(name = "totalNormal")
    @EticketFormField(label = "Total Normal tickets: ", fieldType = "number")
    private int totalNormal;
    @EticketTableColHeader(headerLabel = "Normal Ticket Amount")
    @Column(name = "normalAmount")
    @EticketFormField(label = "Normal ticket amount: ", fieldType = "number")
    private int normalAmount;


    @Column(name = "totalVipTicketsSold")
    private  int totalVipTicketsSold;

    @Column(name = "totalNormalTicketsSold")
    private int totalNormalTicketsSold;

    @Formula("(coalesce(totalVipTicketsSold,0) + coalesce(totalNormalTicketsSold,0))")
    private int totalTicketsSold;

    @Formula("(coalesce(totalVipTicketsSold,0) * coalesce(vipAmount,0))")
    private int vipRevenue;

    @Formula("(coalesce(totalNormalTicketsSold,0) * coalesce(normalAmount,0))")
    private int normalRevenue;

    @Formula("(coalesce(normalRevenue,0) + coalesce(vipRevenue,0))")
    private int totalRevenueGenerated;

    @JsonIgnore
    @OneToOne(mappedBy="ticketManagement", cascade = CascadeType.ALL)
    private Fixture fixture;

//    @EticketTableColHeader(headerLabel = "Edit")
//    @Transient
//    private String action = "<img width=\"22\" height=\"22\" src=\"https://img.icons8.com/cotton/64/create-new--v2.png\" alt=\"create-new--v2\"/>";




    public TicketManagement(int id,FixtureType fixtureType, int totalTickets, int totalVip, int vipAmount, int totalNormal, int normalAmount, int totalVipTicketsSold, int totalNormalTicketsSold) {
        setId(id);
        this.fixtureType = fixtureType;
        this.totalTickets = totalTickets;
        this.totalVip = totalVip;
        this.vipAmount = vipAmount;
        this.totalNormal = totalNormal;
        this.normalAmount = normalAmount;
        this.totalVipTicketsSold = totalVipTicketsSold;
        this.totalNormalTicketsSold = totalNormalTicketsSold;
    }

    public FixtureType getFixtureType() {
        return fixtureType;
    }

    public void setFixtureType(FixtureType fixtureType) {
        this.fixtureType = fixtureType;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getTotalVip() {
        return totalVip;
    }

    public void setTotalVip(int totalVip) {
        this.totalVip = totalVip;
    }

    public int getVipAmount() {
        return vipAmount;
    }

    public void setVipAmount(int vipAmount) {
        this.vipAmount = vipAmount;
    }

    public int getTotalNormal() {
        return totalNormal;
    }

    public void setTotalNormal(int totalNormal) {
        this.totalNormal = totalNormal;
    }

    public int getNormalAmount() {
        return normalAmount;
    }

    public void setNormalAmount(int normalAmount) {
        this.normalAmount = normalAmount;
    }

    public int getVipRevenue() {
        return vipRevenue;
    }

    public void setVipRevenue(int vipRevenue) {
        this.vipRevenue = vipRevenue;
    }

    public int getNormalRevenue() {
        return normalRevenue;
    }

    public void setNormalRevenue(int normalRevenue) {
        this.normalRevenue = normalRevenue;
    }

    public Fixture getFixture() {
        return fixture;
    }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }


    public int getTotalVipTicketsSold() {
        return totalVipTicketsSold;
    }

    public void setTotalVipTicketsSold(int totalVipTicketsSold) {
        this.totalVipTicketsSold = totalVipTicketsSold;
    }

    public int getTotalNormalTicketsSold() {
        return totalNormalTicketsSold;
    }

    public void setTotalNormalTicketsSold(int totalNormalTicketsSold) {
        this.totalNormalTicketsSold = totalNormalTicketsSold;
    }

    public int getTotalRevenueGenerated() {
        return totalRevenueGenerated;
    }

    public void setTotalRevenueGenerated(int totalRevenueGenerated) {
        this.totalRevenueGenerated = totalRevenueGenerated;
    }

    public TicketManagement() {
    }

    @Override
    public String toString() {
        return "TicketManagement{" +
                "totalTickets=" + totalTickets +
                ", totalVip=" + totalVip +
                ", vipAmount=" + vipAmount +
                ", totalNormal=" + totalNormal +
                ", normalAmount=" + normalAmount +
                ", totalTicketsSold=" + totalTicketsSold +
                ", totalVipTicketsSold=" + totalVipTicketsSold +
                ", totalNormalTicketsSold=" + totalNormalTicketsSold +
                ", vipRevenue=" + vipRevenue +
                ", normalRevenue=" + normalRevenue +
                ", totalRevenueGenerated=" + totalRevenueGenerated +
                '}';
    }
}
