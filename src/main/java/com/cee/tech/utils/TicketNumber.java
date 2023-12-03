package com.cee.tech.utils;

import javax.inject.Inject;
import javax.inject.Named;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Named("Ticket")
public class TicketNumber implements UniqueNoGenerator {

    @Inject
    @UniqueNo(type = UniqueNumberType.TICKET_NO)
    private int ticketNoInfo;

    public String generate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
        return "TIC" + dateFormat.format(new Date()) + "-" + ticketNoInfo;
    }
}
