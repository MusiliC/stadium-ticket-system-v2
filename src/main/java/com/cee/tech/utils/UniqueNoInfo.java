package com.cee.tech.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
public class UniqueNoInfo {

    @Produces
    @UniqueNo(type = UniqueNumberType.TICKET_NO)
    int ticketNoInfo(){
        return  ThreadLocalRandom.current().nextInt(1000, 2000 + 1);
    }

    int paymentNoInfo(){
        return  ThreadLocalRandom.current().nextInt(1000, 2000 + 1);
    }
}
