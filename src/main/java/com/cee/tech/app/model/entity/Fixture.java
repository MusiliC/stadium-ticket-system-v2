package com.cee.tech.app.model.entity;

import com.cee.tech.database.helper.DbTable;
import com.cee.tech.database.helper.DbTableColumn;
import com.cee.tech.view.html.EticketFixtureCard;
import com.cee.tech.view.html.EticketFormField;
import com.cee.tech.view.html.EticketHtmlForm;
import com.cee.tech.view.html.EticketTableColHeader;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@EticketHtmlForm(label = "Fixture", url = "./adminfixtures", httpMethod = "POST")
@DbTable(name = "fixtures")
public class Fixture extends BaseEntity {


    @EticketFormField(label = "Fixture Type")
    @EticketTableColHeader(headerLabel = "Fixture Type")
    @DbTableColumn(name = "fixtureType", notNull = "not null")
    private FixtureType fixtureType;
    @EticketFormField(label = "Fixture Time", fieldType = "time")
    @EticketTableColHeader(headerLabel = "Time")
    @DbTableColumn(name = "fixtureTime", notNull = "not null")
    private String fixtureTime;
    @EticketFormField(label = "Fixture Location")
    @EticketTableColHeader(headerLabel = "Location")
    @DbTableColumn(name = "fixtureLocation", notNull = "not null")
    private String fixtureLocation;
    @EticketFormField(label = "Home Team")
    @EticketTableColHeader(headerLabel = "Home Team")
    @DbTableColumn(name = "homeTeam", notNull = "not null")
    private String homeTeam;
    @EticketFormField(label = "Away Team")
    @EticketTableColHeader(headerLabel = "Away Team")
    @DbTableColumn(name = "awayTeam", notNull = "not null")
    private String awayTeam;
    @EticketFormField(label = "Fixture Date", fieldType = "date")
    @EticketTableColHeader(headerLabel = "Date")
    @DbTableColumn(name = "fixtureDate", notNull = "not null")
    private String fixtureDate;
    @EticketTableColHeader(headerLabel = "Action")
    private String action = "Edit";


    public FixtureType getFixtureType() {
        return fixtureType;
    }


    public Fixture(int id, String fixtureTime, String fixtureLocation, String homeTeam,
                   String awayTeam, String fixtureDate) {
        setId(id);
        this.fixtureTime = fixtureTime;
        this.fixtureLocation = fixtureLocation;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.fixtureDate = fixtureDate;
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

    public void setFixtureType(FixtureType fixtureType) {
        this.fixtureType = fixtureType;
    }

    public Fixture() {
    }

    public String tableRow() {
        StringBuilder tbBuilder = new StringBuilder();
        tbBuilder.append("<div class=\"oneFixture\">");
        tbBuilder.append("<div class=\"fixture\">");
        // tbBuilder.append("<p>").append(StringUtils.trimToEmpty(getFixtureType())).append("</p>");
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
        // tbBuilder.append("<p>").append(StringUtils.trimToEmpty(getFixtureType())).append("</p>");
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}
