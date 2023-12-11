package com.cee.tech.app.model.entity;

import com.cee.tech.database.helper.DbTable;
import com.cee.tech.database.helper.DbTableColumn;
import com.cee.tech.view.html.EticketFormField;
import com.cee.tech.view.html.EticketHtmlCard;
import com.cee.tech.view.html.EticketHtmlForm;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;


@NamedQueries({
        @NamedQuery(name = BookTicket.bookTicketFindUserById,query = "FROM BookTicket t WHERE t.user.id = 17"),
//        @NamedQuery(name = BookTicket.SelectTicketsWithFixture, query = "select t.ticketNumber, f.fixtureType, f.homeTeam, f.awayTeam, f.fixtureDate " +
//                " from bookTicket t inner join fixtures f on t.ticket_fixture_desc = f.id"),
//        @NamedQuery(name = BookTicket.selectTicketDescWithBookTicket, query= "select t.ticketNumber, f.fixtureType,d.totalTickets from bookTicket t left " +
//                " join fixtures f  on t.ticket_fixture_desc = f.id  join ticketManagement d on f.fixture_desc_id = d.id")
})
@Entity
@Table(name = "bookTicket")
//@AttributeOverride(name = "id", column = @Column(name = "ticketId"))
@EticketHtmlForm(label = "Ticket", url = "./book")
public class BookTicket implements Serializable {

    public static final String bookTicketFindUserById = "BookTicket.bookTicketFindUserById";
    public static final String SelectTicketsWithFixture= "BookTicket.selectTicketsWithFixture";
    public static final String selectTicketDescWithBookTicket = "BookTicket.selectTicketDescWithBookTicket";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticketId")
    private int ticketId;


    @Column(name = "ticketNumber")
    @EticketHtmlCard(cssClass = "ticketNumber")
    private String ticketNumber;

    @EticketHtmlCard(cssClass = "ticketFixtureType")
    @Transient
    private String fixtureType = "CAF Champions League";

    @EticketHtmlCard(cssClass = "newTicketInfoDetails", pTag = "bookTicketHomeTeam")
    @Transient
    private String homeTeam = "Gor Mahia";
    @EticketHtmlCard(cssClass = "newTicketInfoDetails", pTag = "bookTicketAwayTeam")
    @Transient
    private String awayTeam = "AFC Leopards";


    @EticketFormField(label = "Ticket Type", name = "ticketType")
    @Column(name = "ticketType")
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    @EticketHtmlCard(cssClass = "ticketDate")
    @Transient
    private String date = "2023/11/11";

    @EticketHtmlCard(cssClass = "ticketFixtureType")
    @Formula("(select u.username from users u where u.id = user_id)")
    private String ticketOwner;
    @EticketFormField(label = "Number of Tickets", fieldType = "number", name = "totalTickets")
    @Column(name = "totalTickets")
    private int totalTickets;

    @Embedded
    private UserDetails userDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ticket_fixture_desc", nullable=false)
    private Fixture fixture;

    @Formula("ticketId")
    @EticketFormField(label = "User id", fieldType = "number", name = "userId")
    private int userId;

    @EticketFormField(label = "Fixture id", fieldType = "number", name = "fixtureId")
    @Transient
    private int fixtureId;


//    @Formula("(select u.name from users u where u.id=id)")
//    private String username;


    public BookTicket() {
    }

    public BookTicket(int ticketId, String ticketNumber, TicketType ticketType, int totalTickets) {
        this.ticketId = ticketId;
        this.ticketNumber = ticketNumber;
        this.ticketType = ticketType;
        this.totalTickets = totalTickets;
    }


    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }


    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getFixtureType() {
        return fixtureType;
    }

    public void setFixtureType(String fixtureType) {
        this.fixtureType = fixtureType;
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

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public String getTicketOwner() {
        return ticketOwner;
    }

    public void setTicketOwner(String ticketOwner) {
        this.ticketOwner = ticketOwner;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Fixture getFixture() {
        return fixture;
    }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }

    public int getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(int fixtureId) {
        this.fixtureId = fixtureId;
    }
}