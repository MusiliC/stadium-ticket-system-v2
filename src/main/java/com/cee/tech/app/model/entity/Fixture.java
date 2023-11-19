package com.cee.tech.app.model.entity;

import com.cee.tech.view.html.EticketFormField;
import com.cee.tech.view.html.EticketHtmlForm;
import com.cee.tech.view.html.EticketTableColHeader;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@EticketHtmlForm(label = "Fixture", url = "./adminfixtures", httpMethod = "POST")
public class Fixture implements Serializable {


    private String fixtureId;
    @EticketFormField(label = "Fixture Type")
    @EticketTableColHeader(headerLabel = "Fixture Type")
    private String fixtureType;
    @EticketFormField(label = "Fixture Time", fieldType = "time")
    @EticketTableColHeader(headerLabel = "Fixture Time")
    private String fixtureTime;
    @EticketFormField(label = "Fixture Location")
    @EticketTableColHeader(headerLabel = "Fixture Location")
    private String fixtureLocation;
    @EticketFormField(label = "Home Team")
    @EticketTableColHeader(headerLabel = "Home Team")
    private String homeTeam;
    @EticketFormField(label = "Away Team")
    @EticketTableColHeader(headerLabel = "Away Team")
    private String awayTeam;
    @EticketFormField(label = "Fixture Date", fieldType = "date")
    @EticketTableColHeader(headerLabel = "Fixture Date")
    private String fixtureDate;


    public String getFixtureType() {
        return fixtureType;
    }


    public Fixture(String fixtureType, String fixtureTime, String fixtureLocation, String homeTeam, String awayTeam, String fixtureDate) {
        this.fixtureType = fixtureType;
        this.fixtureTime = fixtureTime;
        this.fixtureLocation = fixtureLocation;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.fixtureDate = fixtureDate;
    }

    public Fixture(String fixtureId, String fixtureType, String fixtureTime, String fixtureLocation, String homeTeam, String awayTeam, String fixtureDate) {
        this.fixtureId = fixtureId;
        this.fixtureType = fixtureType;
        this.fixtureTime = fixtureTime;
        this.fixtureLocation = fixtureLocation;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.fixtureDate = fixtureDate;
    }

    public String getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(String fixtureId) {
        this.fixtureId = fixtureId;
    }

    public String getFixtureTime() {
        return fixtureTime;
    }

    public void setFixtureTime(String fixtureTime) {
        this.fixtureTime = fixtureTime;
    }

    public String getFixtureDate() {
        return fixtureDate;
    }

    public void setFixtureDate(String fixtureDate) {
        this.fixtureDate = fixtureDate;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getFixtureLocation() {
        return fixtureLocation;
    }

    public void setFixtureLocation(String fixtureLocation) {
        this.fixtureLocation = fixtureLocation;
    }

    public void setFixtureType(String fixtureType) {
        this.fixtureType = fixtureType;
    }

    public Fixture() {
    }


    public String tableRow() {
        StringBuilder tbBuilder = new StringBuilder();
        tbBuilder.append("<div class=\"oneFixture\">");
        tbBuilder.append("<div class=\"fixture\">");
        tbBuilder.append("<td>").append(StringUtils.trimToEmpty(getFixtureType())).append("</td>");
        tbBuilder.append(" </div>");
        tbBuilder.append("  <div class=\"timeLocation\">");
        tbBuilder.append("<p>").append(StringUtils.trimToEmpty(getFixtureTime())).append("</p>");
        tbBuilder.append("<p>").append(StringUtils.trimToEmpty(getFixtureLocation())).append("</p>");
        tbBuilder.append(" </div>");
        tbBuilder.append("<div class=\"teams\">");
        tbBuilder.append("<p>").append(StringUtils.trimToEmpty(getHomeTeam())).append("</p>");
        tbBuilder.append("<p>").append(StringUtils.trimToEmpty(getAwayTeam())).append("</p>");
        tbBuilder.append(" </div>");
        tbBuilder.append("<div class=\"date\">");
        tbBuilder.append("<td>").append(StringUtils.trimToEmpty(getFixtureDate())).append("</td>");
        tbBuilder.append(" </div>");
        tbBuilder.append("<div class=\"ticket\">");
        tbBuilder.append("  <div class=\"outlineTicketButton\"><a href=\"./book\">Buy Ticket</a> </div>");
        tbBuilder.append("</div>");
        tbBuilder.append("</div>");
        return tbBuilder.toString();

    }

    public String tableAdminRow() {
        StringBuilder tbBuilder = new StringBuilder();
        tbBuilder.append("<div class=\"oneFixture\">");
        tbBuilder.append("<div class=\"fixture\">");
        tbBuilder.append("<td>").append(StringUtils.trimToEmpty(getFixtureType())).append("</td>");
        tbBuilder.append(" </div>");
        tbBuilder.append("  <div class=\"timeLocation\">");
        tbBuilder.append("<p>").append(StringUtils.trimToEmpty(getFixtureTime())).append("</p>");
        tbBuilder.append("<p>").append(StringUtils.trimToEmpty(getFixtureDate())).append("</p>");
        tbBuilder.append("<p>").append(StringUtils.trimToEmpty(getFixtureLocation())).append("</p>");
        tbBuilder.append(" </div>");
        tbBuilder.append("<div class=\"teams\">");
        tbBuilder.append("<p>").append(StringUtils.trimToEmpty(getHomeTeam())).append("</p>");
        tbBuilder.append("<p>").append(StringUtils.trimToEmpty(getAwayTeam())).append("</p>");
        tbBuilder.append(" </div>");
        tbBuilder.append("  <div class=\"homeButtons\">\n" +
                "              <a href=\"./#\" class=\"homeOutlineButton\" >Edit</a>\n" +
                "              <a href=\"./#\" class=\"homeNormalButton\">Delete</a>\n" +
                "        </div>");
        tbBuilder.append("</div>");
        return tbBuilder.toString();

    }

}
