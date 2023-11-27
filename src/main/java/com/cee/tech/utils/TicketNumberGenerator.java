package com.cee.tech.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class TicketNumberGenerator {
    public String generate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");

        return "TIC" + dateFormat.format(new Date()) + "-" + ThreadLocalRandom.current().nextInt(1000, 2000 + 1);
    }
}
